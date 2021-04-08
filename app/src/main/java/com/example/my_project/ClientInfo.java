package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ClientInfo extends AppCompatActivity {
    Intent prev = null;
    Intent i = null;
    String clientToShow = "";
    TextView clientShowHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_info);

        clientShowHolder = findViewById(R.id.infoClient);
        i = getIntent();
        prev = new Intent(this,Meetings.class);
        clientToShow = i.getStringExtra("Client");
  
        clientShowHolder.setText(clientToShow);



    }


    public void mtPartPay(View view) {
        Intent partPayPage = new Intent(this, PartialPayment.class);
        startActivity(partPayPage);
    }
    public void returnToPrev(View view) {
        startActivity(prev);
    }
}