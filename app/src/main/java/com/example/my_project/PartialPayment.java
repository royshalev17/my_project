package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PartialPayment extends AppCompatActivity {
    Intent prev = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partial_payment);
        prev =  new Intent(this,ClientInfo.class);

    }
    public void returnToPrev(View view) {
        startActivity(prev);
    }
}