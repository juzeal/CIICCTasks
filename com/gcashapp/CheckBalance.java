package com.gcashapp;

import java.util.ArrayList;
import java.util.List;

public class CheckBalance {
    private List<Balance> balances; 
    private int nextBalanceId = 2001; 

    public CheckBalance() {
        this.balances = new ArrayList<>();
        
    }

   
    public void addInitialBalance(int userId, double initialAmount) {
        Balance newBalance = new Balance(nextBalanceId++, initialAmount, userId);
        balances.add(newBalance);
        System.out.println("Initial balance set for user ID " + userId + ": " + initialAmount);
    }

    
    public double getUserBalance(int userId) {
        for (Balance balance : balances) {
            if (balance.getUserId() == userId) {
                return balance.getAmount();
            }
        }
        System.out.println("Error: Balance not found for user ID: " + userId);
        return 0.0; 
    }

    
    public boolean updateBalance(int userId, double amountChange) {
        for (Balance balance : balances) {
            if (balance.getUserId() == userId) {
                double newAmount = balance.getAmount() + amountChange;
                if (newAmount < 0) {
                    System.out.println("Error: Insufficient balance for user ID " + userId);
                    return false; 
                }
                balance.setAmount(newAmount);
                return true;
            }
        }
        System.out.println("Error: User balance record not found for user ID " + userId);
        return false;
    }

    
    public void listAllBalances() {
        System.out.println("\n--- All Account Balances ---");
        if (balances.isEmpty()) {
            System.out.println("No balances recorded yet.");
            return;
        }
        for (Balance balance : balances) {
            System.out.println(balance.toString());
        }
        System.out.println("----------------------------\n");
    }
}