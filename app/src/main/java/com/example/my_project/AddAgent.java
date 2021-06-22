package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddAgent extends AppCompatActivity {
String userNameStr;
String passwordStr;
EditText userName;
EditText password;
    Intent prev =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_agent);
        userName = findViewById(R.id.AgntUsName);
        password = findViewById(R.id.AgntPass);
        prev =  new Intent(this,AgentList.class);
    }
    public void returnToPrev(View view) {
        startActivity(prev);
    }
    public void addNewAgent(View view)
    {
        Dal AgentDal = new Dal(AddAgent.this);
        userNameStr = userName.getText().toString();
        passwordStr = password.getText().toString();
        if (AgentDal.Check_If_Agent_Exists(userNameStr))
        {
            Toast.makeText(this, "This username is already taken!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            AgentDal.addAgent(userNameStr, passwordStr);
            Toast.makeText(this, "Agent: " + userNameStr + "has been added successfully!", Toast.LENGTH_SHORT).show();
        }

    }

}