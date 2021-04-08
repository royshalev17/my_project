package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        userNameStr = userName.getText().toString();
        passwordStr = password.getText().toString();
    }

}