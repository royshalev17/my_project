package com.example.my_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar extends AppCompatActivity {
CalendarView cal;
String date;
Intent PrevPage;
String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        PrevPage = getIntent();
        userName = PrevPage.getStringExtra("currUser");
        cal = (CalendarView) findViewById(R.id.calendarView);
        date = "";
        cal.setOnDateChangeListener(calListener);





    }
    CalendarView.OnDateChangeListener calListener = new CalendarView.OnDateChangeListener(){

        public void onSelectedDayChange(CalendarView view, int year, int month, int day){

            // add one because month starts at 0
            month++;
            if (day <10){
                date = "0" + day;
            }
            else
            {
                date = ""+day;
            }
            if (month < 10)
            {
                date += "/0"+ month;
            }
            else
            {
                date += "/"+month;
            }
            date+= "/" + year;

        }
    };

    public void viewDate(View view) {

        Dal dal = new Dal(Calendar.this);
        if (dal.isManager(userName))
        {
            PrevPage = new Intent(this, AgentList.class);
        }
        else
            PrevPage = new Intent(this, Meetings.class);

        PrevPage.putExtra("username", userName);
        PrevPage.putExtra("date" , date);
        Log.d("ttty", "viewDate: " + userName);

        startActivity(PrevPage);
    }
}