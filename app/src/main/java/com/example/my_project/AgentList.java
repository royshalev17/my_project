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

import com.example.my_project.AddAgent;
import com.example.my_project.Calendar;
import com.example.my_project.Dal;
import com.example.my_project.R;
import com.example.my_project.Report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class AgentList extends AppCompatActivity {
    ListView agentList;
    ArrayList<String> agents = new ArrayList<>();
    String date =new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());;
    String userName;
    TextView dateD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_list);
        agentList = findViewById(R.id.agents);
        Intent i = getIntent();
        dateD = (TextView)findViewById(R.id.dateDesplay);
        if (i.getStringExtra("date") != null && i.getStringExtra("date") != "")
        {
            date = i.getStringExtra("date");
        }
        dateD.setText(date);
        userName = i.getStringExtra("username");
        Dal dal = new Dal(AgentList.this);

        agents = dal.getAllAgents();
        ArrayAdapter<String> arrayAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, agents);
        agentList.setAdapter(arrayAdapt);
        agentList.setOnItemClickListener(agentsListener);
    }



    private AdapterView.OnItemClickListener agentsListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent reportPage = new Intent(AgentList.this, Report.class);
            reportPage.putExtra("creator",agents.get(position));
            reportPage.putExtra("date",date);
            startActivity(reportPage);
        }

    };



    public void mtAddAgent(View view) {
        Intent addAgentPage = new Intent(this, AddAgent.class);
        startActivity(addAgentPage);
    }

    public void openCldr(View view) {
        Intent calendarPage = new Intent(this, Calendar.class);
        calendarPage.putExtra("currUser", userName);
        startActivity(calendarPage);
    }
}