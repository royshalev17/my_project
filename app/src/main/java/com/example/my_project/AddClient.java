package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddClient extends AppCompatActivity {
    Intent prev = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        prev =  new Intent(this,Meetings.class);
    }
    public void returnToPrev(View view) {
        startActivity(prev);
    }
}