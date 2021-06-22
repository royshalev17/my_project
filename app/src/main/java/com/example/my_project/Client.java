package com.example.my_project;

public class Client {
    private String clientName;
    private String orderInfo;
    private int sumOfMoney;
    private String address;
    private String phoneNumber;
    private Boolean hasPaid;
    private String date;
    String creator;
    public Client(String clientNameIn, String orderInfoIn, int sumOfMoneyIn, String addressIn, String phoneNumberIn, String date,String creator)
    {
        this.clientName = clientNameIn;
        this.orderInfo = orderInfoIn;
        this.sumOfMoney = sumOfMoneyIn;
        this.address = addressIn;
        this.phoneNumber = phoneNumberIn;
        hasPaid = false;
        this.date = date;
        this.creator = creator;
    }

    public Client(){}

    public String getCreator() {
        return creator;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public Boolean getHasPaid() {
        return hasPaid;
    }

    public int getSumOfMoney() {
        return sumOfMoney;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setHasPaid(Boolean hasPaid) {
        this.hasPaid = hasPaid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public void setSumOfMoney(int sumOfMoney) {
        this.sumOfMoney = sumOfMoney;
    }
    @Override
    public String toString(){
        return "ClientName: " + this.clientName + "\n\n" +
                "Address: " + this.address + "\n\n" +
                "Order Description: " + orderInfo + "\n\n" +
                "Sum of purchase: " + this.sumOfMoney + "\n\n" +
                "Contact Number: " + this.phoneNumber;
    }
}
