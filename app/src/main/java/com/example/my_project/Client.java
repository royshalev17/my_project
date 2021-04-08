package com.example.my_project;

public class Client {
    private String clientName;
    private String orderInfo;
    private int sumOfMoney;
    private String address;
    private String phoneNumber;
    private Boolean hasPaid;
    public Client(String clientNameIn, String orderInfoIn, int sumOfMoneyIn, String addressIn, String phoneNumberIn)
    {
        this.clientName = clientNameIn;
        this.orderInfo = orderInfoIn;
        this.sumOfMoney = sumOfMoneyIn;
        this.address = addressIn;
        this.phoneNumber = phoneNumberIn;
        hasPaid = false;
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

    public void setHasPaid(Boolean hasPaid) {
        this.hasPaid = hasPaid;
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
