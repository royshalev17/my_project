package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class PartialPayment extends AppCompatActivity {
    Intent prev = null;
    EditText NewAmount;
    EditText NewSum;
    String name;
    String date;
    String agent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partial_payment);
        prev =  getIntent();
        date = prev.getStringExtra("date");
        agent =  prev.getStringExtra("agent");
        name = prev.getStringExtra("name");
        NewAmount = (EditText)findViewById(R.id.amount);
        NewSum = (EditText)findViewById(R.id.sum);



    }
    public void returnToPrev(View view) {
        finish();
    }

    public void updatePayment(View view) {
        Dal dal = new Dal(PartialPayment.this);
        Log.w("myApp","name: " + name +"\ndate: " + date + "\nagent: " + agent);
        if(!dal.hasPaid(name, date, agent))
        {
            dal.updateOrder(NewAmount.getText().toString(),  NewSum.getText().toString(), name, date, agent);
            Log.w("myApp", NewAmount.getText().toString());

        }
        else
        {
            ArrayList<Client> clients = dal.getAllClientsByDateAndCreator(date, agent);
            int i =0;
            int sum = 0;
            for(i =0; i < clients.size(); i++)
            {
                Log.w("myApp", clients.get(i).getClientName() + "==" + name);
                if (clients.get(i).getClientName().equals(name))
                {
                    sum = clients.get(i).getSumOfMoney();
                }

            }
            Log.w("myApp", "New Sum" + (Integer.parseInt(dal.getReport(date, agent).getSum()) - sum + Integer.parseInt(NewSum.getText().toString())));
            dal.updateReport("" + (Integer.parseInt(dal.getReport(date, agent).getSum()) - sum + Integer.parseInt(NewSum.getText().toString())), date);
            dal.updateOrder(NewAmount.getText().toString(),  NewSum.getText().toString(), name, date, agent);
        }




    }
}