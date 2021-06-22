package com.example.my_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Dal extends SQLiteAssetHelper {
    public Dal(Context context) {
        super(context, "commanagerDb.db", null, 1);

    }

    public Boolean Check_If_Agent_Exists(String username) {
        String st = "select * from agents";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        while (cursor.moveToNext()) {
            if (cursor.getString(cursor.getColumnIndex("username")).equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void addAgent(String UserName, String Password) {
        SQLiteDatabase db = getWritableDatabase();
        String sql_INSERT = "INSERT INTO agents (username ,password ,isAdmin) values(?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql_INSERT);
        statement.bindString(1, UserName);
        statement.bindString(2, Password);
        statement.bindString(3, "false");
        statement.execute();
    }

    public void addClient(String Name, String Info, String Sum, String Address, String PhoneNumber, Boolean HasPaid, String Date, String Agent) {
        SQLiteDatabase db = getWritableDatabase();
        String sql_INSERT = "INSERT INTO clients (name ,info ,sum ,address ,phone_number ,has_paid ,[date] ,agent) values(?,?,?,?,?,?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql_INSERT);

        statement.bindString(1, Name);
        statement.bindString(2, Info);
        statement.bindString(3, Sum);
        statement.bindString(4, Address);
        statement.bindString(5, PhoneNumber);
        if (HasPaid)
            statement.bindString(6, "true");
        else
            statement.bindString(6, "false");
        statement.bindString(7, Date);
        statement.bindString(8, Agent);

        statement.execute();
    }

    public Boolean Check_If_Password_Correct(String username, String password) {
        String st = "select * from agents";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        while (cursor.moveToNext()) {
            if (cursor.getString(cursor.getColumnIndex("username")).equals(username) && cursor.getString(cursor.getColumnIndex("password")).equals(password)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Client> getAllClientsByDateAndCreator(String date, String creator) {
        ArrayList<Client> ary = new ArrayList<>();

        String st = "select * from clients Where date='" + date + "' AND agent='" + creator +"'";
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(st, null);
        while (cursor.moveToNext()) {
            Client c = new Client();
            c.setClientName(cursor.getString(cursor.getColumnIndex("name")));
            c.setOrderInfo(cursor.getString(cursor.getColumnIndex("info")));
            c.setSumOfMoney(Integer.parseInt(cursor.getString(cursor.getColumnIndex("sum"))));
            c.setAddress(cursor.getString(cursor.getColumnIndex("address")));
            c.setPhoneNumber(cursor.getString(cursor.getColumnIndex("phone_number")));
            c.setHasPaid(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex("has_paid"))));
            c.setDate(date);

            ary.add(c);
        }
        return ary;

    }
    public Boolean isManager(String username) {
        String st = "select * from agents";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        while (cursor.moveToNext()) {
            if (cursor.getString(cursor.getColumnIndex("username")).equals(username) && cursor.getString(cursor.getColumnIndex("isAdmin")).equals("true")) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<String> getAllAgents() {
        ArrayList<String> ary = new ArrayList<>();

        String st = "select * from agents Where isAdmin='false'";
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(st, null);
        while (cursor.moveToNext()) {
            ary.add(cursor.getString(cursor.getColumnIndex("username")));



        }
        return ary;

    }

    public void updateOrder(String newOrder, String newSum, String businessName) {
        SQLiteDatabase db = getWritableDatabase();
        String st = "UPDATE clients set info='"+ newOrder + "' ,sum='" + newSum + "' WHERE name='" + businessName + "'";
        SQLiteStatement statement = db.compileStatement(st);
        statement.execute();


    }

    public ReportCard getReport(String date) {
        ReportCard report = new ReportCard();

        String st = "select * from reports Where date='" + date + "'";
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(st, null);
        Log.w("myApp", "date:" + date);
        while (cursor.moveToNext()) {
            report.setAgentName(cursor.getString(cursor.getColumnIndex("agent_name")));
            report.setDate(date);
            report.setSum(cursor.getString(cursor.getColumnIndex("sum")));


        }
        return report;
    }

    public void addReport(String agent,  String price,  String date) {


        SQLiteDatabase db = getWritableDatabase();
        String sql_INSERT = "INSERT INTO reports (agent_name ,sum ,date) values(?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql_INSERT);

        statement.bindString(1, agent);
        statement.bindString(2, price);
        statement.bindString(3, date);

        statement.execute();
    }


    public void updateOrder(String newSum, String date) {
        SQLiteDatabase db = getWritableDatabase();
        String st = "UPDATE reports set sum='" + newSum + "' WHERE date'" + date + "'";
        SQLiteStatement statement = db.compileStatement(st);
        statement.execute();


    }
    public int getSum(String date)
    {
        int sum =0;
        String st = "select * from reports Where date='" + date + "'";
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(st, null);
        while (cursor.moveToNext()) {

            sum = Integer.parseInt(cursor.getString(cursor.getColumnIndex("sum")));


        }
        return sum;
    }


    public boolean checkIfReportExist(String date) {
        String st = "select * from reports";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        while (cursor.moveToNext()) {
            if (cursor.getString(cursor.getColumnIndex("date")).equals(date)) {
                return true;
            }
        }
        return false;
    }

}

