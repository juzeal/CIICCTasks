package com.gcashapp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors; 

public class Transactions {
    private List<Transaction> transactionHistory; 
    private int nextTransactionId = 3001; 

    public Transactions() {
        this.transactionHistory = new ArrayList<>();
    }

    
    public void recordTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
        System.out.println("Transaction recorded: " + transaction.getType() + " - ID: " + transaction.getId());
    }

    
    public int getNextTransactionId() {
        return nextTransactionId++;
    }

   
    public List<Transaction> viewAllTransactions() {
        return new ArrayList<>(transactionHistory); 
    }

    
    public List<Transaction> viewUserTransactions(int userId) {
        return transactionHistory.stream()
                                 .filter(t -> t.getAccountId() == userId || 
                                              (t.getTransferToId() != null && t.getTransferToId() == userId) || 
                                              (t.getTransferFromId() != null && t.getTransferFromId() == userId)) 
                                 .collect(Collectors.toList());
    }

    
    public Transaction viewTransactionById(int transactionId) {
        for (Transaction transaction : transactionHistory) {
            if (transaction.getId() == transactionId) {
                return transaction;
            }
        }
        return null; 
    }

    
    public void listAllTransactions() {
        System.out.println("\n--- All Recorded Transactions ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions recorded yet.");
            return;
        }
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction.toString());
        }
        System.out.println("---------------------------------\n");
    }
}