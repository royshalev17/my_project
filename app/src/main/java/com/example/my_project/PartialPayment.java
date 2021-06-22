package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PartialPayment extends AppCompatActivity {
    Intent prev = null;
    EditText NewAmount;
    EditText NewSum;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partial_payment);
        prev =  new Intent(this,ClientInfo.class);
        name = prev.getStringExtra("name");
        NewAmount = (EditText)findViewById(R.id.amount);
        NewSum = (EditText)findViewById(R.id.sum);

    }
    public void returnToPrev(View view) {
        finish();
    }

    public void updatePayment(View view) {
        Dal dal = new Dal(PartialPayment.this);
        dal.updateOrder(NewAmount.getText().toString(),  NewSum.getText().toString(), name);


    }
}