package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Report extends AppCompatActivity {
    TextView date;
    String currDate;
    String currAgent;
    ListView clientsList;
    TextView total_sum;
    int totalSum = 0;
    ArrayList<Client> clientsIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        date = (TextView) findViewById(R.id.report);
        total_sum = findViewById(R.id.total_sum);
        Intent i = getIntent();
        currDate = i.getStringExtra("date");
        currAgent = i.getStringExtra("creator");
        clientsList = findViewById(R.id.reportcard);
        date.setText(currDate + "'s Report");
        setSum();
        setClientsnames();

        ReportAdapter ra = new ReportAdapter(this, R.layout.reportcard, clientsIn);
        clientsList.setAdapter(ra);

    }
    private void setSum()
    {
        Dal dal = new Dal(Report.this);
        Log.w("myApp", "Total sum: " + dal.getReport(currDate).getSum());
        total_sum.setText("Total sum: " + dal.getReport(currDate).getSum());
    }
    private void setClientsnames()
    {
        int i =0;
        Dal dal = new Dal(Report.this);
        clientsIn = dal.getAllClientsByDateAndCreator(currDate,currAgent);


    }


    public void returnToPrev(View view) {
        finish();
    }
}