package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AgentList extends AppCompatActivity {
ListView agentList;
    String[] agents = {"agent1", "agent2", "agent3", "agent4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_list);
        agentList = findViewById(R.id.agents);
        ArrayAdapter<String> arrayAdapt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, agents);
        agentList.setAdapter(arrayAdapt);


        agentList.setOnItemClickListener(agentsListener);
    }
    private AdapterView.OnItemClickListener agentsListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent reportPage = new Intent(AgentList.this, Report.class);
            reportPage.putExtra("agentName",agents[position]);
            startActivity(reportPage);
        }

    };

    public void mtAddAgent(View view) {
        Intent addAgentPage = new Intent(this, AddAgent.class);
        startActivity(addAgentPage);
    }
}