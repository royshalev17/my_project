package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Meetings extends AppCompatActivity {
Client[] clients = {new Client("client1","50 Galaxy A70", 15000,"BlaBla5, Tel Aviv","05455555555")};
ArrayList<String> clientsName = new ArrayList<>();
ListView clientsList;
TextView date;
String currDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetings);
        date = findViewById(R.id.meetingsDate);
        Intent i = getIntent();
        currDate = i.getStringExtra("date");
        date.setText(currDate);
        clientsList = findViewById(R.id.agents);
        setClientsnames(clients);
        ArrayAdapter<String> arrayAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clientsName);
        clientsList.setAdapter(arrayAdapt);
        clientsList.setOnItemClickListener(clientsListener);
    }
    private void setClientsnames(Client[] clientsIn)
    {
        int i;
        for(i =0; i < clientsIn.length; i++)
        {
            clientsName.add(clientsIn[i].getClientName());
        }


    }
    private AdapterView.OnItemClickListener clientsListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent clientPage = new Intent(Meetings.this, ClientInfo.class);

            clientPage.putExtra("Client", clients[position].toString());
            startActivity(clientPage);
        }
    };

    public void mtAddClient(View view) {
        Intent addClientPage = new Intent(this,AddClient.class);
        startActivity(addClientPage);

    }

    public void mtReport(View view) {
        Intent ReportPage = new Intent(this, Report.class);
        startActivity(ReportPage);
    }

    public void openCldr(View view) {
        Intent calendarPage = new Intent(this, Calendar.class);
        startActivity(calendarPage);
    }
}
