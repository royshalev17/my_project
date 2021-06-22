package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        Dal dal = new Dal(Login.this);
        userNameStr = userName.getText().toString();
        passStr = password.getText().toString();
        if (userNameStr.compareTo("") == 0 || passStr.compareTo("") == 0)
        {
            Toast.makeText(this,"you must fill the inputs!",Toast.LENGTH_LONG).show();
        }
        else if (dal.Check_If_Agent_Exists(userNameStr) && dal.Check_If_Password_Correct(userNameStr, passStr)) {
            if (dal.isManager(userNameStr)) {


                Intent AgentsPage = new Intent(this,AgentList.class);
                AgentsPage.putExtra("username", userNameStr);

                startActivity(AgentsPage);
            } else {


                Intent ClientsPage = new Intent(this, Meetings.class);
                ClientsPage.putExtra("username", userNameStr);
                startActivity(ClientsPage);
            }

        }


    }
}