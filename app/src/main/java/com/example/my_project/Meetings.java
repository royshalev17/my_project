package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.getInstance;

public class Meetings extends AppCompatActivity {
ArrayList<String> clientsName = new ArrayList<>();
ListView clientsList;
TextView date;
Date currentTime = getInstance().getTime();
String currDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
String currAgent;
ArrayList<Client> clientsIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);
        date = findViewById(R.id.meetingsDate);
        Intent i = getIntent();
        if (i.getStringExtra("date") != null && i.getStringExtra("date") != "") { currDate = i.getStringExtra("date");}
        currAgent =  i.getStringExtra("username");
        date.setText(currDate);
        clientsList = findViewById(R.id.meetingsList);
        setClientsnames();
        ArrayAdapter<String> arrayAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clientsName);
        clientsList.setAdapter(arrayAdapt);
        clientsList.setOnItemClickListener(clientsListener);
    }
    private void setClientsnames()
    {
        int i =0;
        Dal dal = new Dal(Meetings.this);
        clientsIn = dal.getAllClientsByDateAndCreator(currDate,currAgent);

        for(i =0; i < clientsIn.size(); i++)
        {
            clientsName.add(clientsIn.get(i).getClientName());
        }


    }
    private AdapterView.OnItemClickListener clientsListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent clientPage = new Intent(Meetings.this, ClientInfo.class);
            clientPage.putExtra("Client", clientsIn.get(position).toString());
            clientPage.putExtra("sum", clientsIn.get(position).getSumOfMoney());
            clientPage.putExtra("date",currDate);
            clientPage.putExtra("name", clientsIn.get(position).getClientName());
            startActivity(clientPage);
        }
    };

    public void mtAddClient(View view) {
        Intent addClientPage = new Intent(this,AddClient.class);
        addClientPage.putExtra("date", currDate);
        addClientPage.putExtra("creator",currAgent);
        Log.d("ttty", "mtAddClient: " + currDate);
        startActivity(addClientPage);

    }

    public void mtReport(View view) {

        Intent ReportPage = new Intent(this, Report.class);
        ReportPage.putExtra("date", currDate);
        ReportPage.putExtra("creator",currAgent);
        startActivity(ReportPage);
    }

    public void openCldr(View view) {
        Intent calendarPage = new Intent(this, Calendar.class);
        calendarPage.putExtra("currUser", currAgent);
        startActivity(calendarPage);
    }
}
