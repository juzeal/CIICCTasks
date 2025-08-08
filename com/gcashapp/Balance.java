package com.gcashapp;

public class Balance {
    private int id; 
    private double amount;
    private int userId; 
    public Balance(int id, double amount, int userId) {
        this.id = id;
        this.amount = amount;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Balance{" +
               "id=" + id +
               ", amount=" + amount +
               ", userId=" + userId +
               '}';
    }
}