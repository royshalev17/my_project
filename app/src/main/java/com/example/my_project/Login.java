package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText userName;
EditText password;
String userNameStr = "";
String passStr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName =(EditText)findViewById(R.id.userName);
        password = (EditText)findViewById(R.id.password);
    }

    public void loginApp(View view) {
        userNameStr = userName.getText().toString();
        passStr = password.getText().toString();
        if (userNameStr.compareTo("") != 0) {
            if (userNameStr.contains("Admin")) {

                Intent AgentsPage = new Intent(this, AgentList.class);
                startActivity(AgentsPage);
            } else {

                Intent ClientsPage = new Intent(this, Meetings.class);
                startActivity(ClientsPage);
            }

        }
        else
        {
            Toast.makeText(this,"you must fill the inputs!",Toast.LENGTH_LONG).show();
        }

    }
}