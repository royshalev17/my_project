package com.example.my_project;

import java.util.ArrayList;

public class Agent {
    private String agentName;
    private String password;
    private ArrayList<Client> clients;
    private Boolean isAdmin;

    public Agent(String agentName, String password)
    {
        this.agentName = agentName;
        this.password = password;
        this.isAdmin = false;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentName='" + agentName + '\'' +
                ", password='" + password + '\'' +
                ", clients=" + clients +
                '}';
    }
}
