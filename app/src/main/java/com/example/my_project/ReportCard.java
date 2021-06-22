package com.example.my_project;

import android.util.Log;

public class ReportCard {
    private String date;
    private String agentName;
    private String sum;
    public ReportCard()
    {

    }
    public ReportCard(String date, String agentName, String sum)
    {
        this.date = date;
        this.agentName =agentName;
        this.sum = sum;

    }

    public String getDate() {
        return date;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getSum() {
        return sum;
    }



    public void setDate(String date) {
        this.date = date;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "ReportCard{" +
                "date='" + date + '\'' +
                ", agentName='" + agentName + '\'' +
                ", sum='" + sum + '\'' +
                '}';
    }
}

