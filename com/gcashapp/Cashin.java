package com.gcashapp;

public class Cashin {
    private CheckBalance checkBalance;
    private Transactions transactions; 
    private int nextTransactionId; 

    public Cashin(CheckBalance checkBalance, Transactions transactions) {
        this.checkBalance = checkBalance;
        this.transactions = transactions;
        
    }

   
    public boolean cashIn(int userId, double amount) {
        if (amount <= 0) {
            System.out.println("Cash-in failed: Amount must be positive.");
            return false;
        }

       
        boolean success = checkBalance.updateBalance(userId, amount);

        if (success) {
            
            transactions.recordTransaction(
                new Transaction(transactions.getNextTransactionId(), amount, "Cash-in", userId)
            );
            System.out.println("Cash-in successful for user ID " + userId + ". Amount: " + String.format("%.2f", amount));
            return true;
        } else {
            System.out.println("Cash-in failed for user ID " + userId + ".");
            return false;
        }
    }
}