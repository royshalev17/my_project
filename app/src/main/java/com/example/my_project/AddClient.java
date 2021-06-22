package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddClient extends AppCompatActivity {
    Intent Prev = null;
    String Date;
    EditText BusinessName;
    EditText Description;
    EditText Sum;
    EditText Address;
    EditText Phone;
    String BusinessNameStr;
    String DescriptionStr;
    String SumStr;
    String AddressStr;
    String PhoneStr;
    String currentAgent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        Prev =  getIntent();
        Date = Prev.getStringExtra("date");
        currentAgent = Prev.getStringExtra("creator");
        BusinessName =(EditText)findViewById(R.id.buisnessName);
        Description =(EditText)findViewById(R.id.amountAnsSpef);
        Sum =(EditText)findViewById(R.id.sum2);
        Address =(EditText)findViewById(R.id.adress);
        Phone =(EditText)findViewById(R.id.phoneNumer);

    }

    public void returnToPrev(View view) {
        Prev = new Intent(this, Meetings.class);
        Prev.putExtra("date", Date);
        Prev.putExtra("username", currentAgent);
        startActivity(Prev);
    }

    public void EnrollClient(View view) {
        Dal ClientDal = new Dal(AddClient.this);
        BusinessNameStr = BusinessName.getText().toString();
        DescriptionStr = Description.getText().toString();
        SumStr = Sum.getText().toString();
        AddressStr = Address.getText().toString();
        PhoneStr = Phone.getText().toString();
        if(!ClientDal.checkIfReportExist(Date))
        {
            ClientDal.addReport(currentAgent, "0", Date);
        }

        ClientDal.addClient(BusinessNameStr, DescriptionStr, SumStr, AddressStr, PhoneStr, false, Date ,currentAgent);
    }
}