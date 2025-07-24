package com.gcashapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private int id; 
    private double amount;
    private String type; 
    private int accountId; 
    private LocalDateTime date;
    private Integer transferToId;   
    private Integer transferFromId; 

    
    public Transaction(int id, double amount, String type, int accountId) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.accountId = accountId;
        this.date = LocalDateTime.now(); 
        this.transferToId = null;
        this.transferFromId = null;
    }

    
    public Transaction(int id, double amount, String type, int accountId, Integer transferToId, Integer transferFromId) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.accountId = accountId;
        this.date = LocalDateTime.now(); 
        this.transferToId = transferToId;
        this.transferFromId = transferFromId;
    }

  
    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public int getAccountId() {
        return accountId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Integer getTransferToId() {
        return transferToId;
    }

    public Integer getTransferFromId() {
        return transferFromId;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = date.format(formatter);
        return "Transaction{" +
               "id=" + id +
               ", amount=" + String.format("%.2f", amount) +
               ", type='" + type + '\'' +
               ", accountId=" + accountId +
               ", date=" + formattedDate +
               (transferToId != null ? ", transferToId=" + transferToId : "") +
               (transferFromId != null ? ", transferFromId=" + transferFromId : "") +
               '}';
    }
}