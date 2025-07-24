package com.gcashapp;

public class CashTransfer {
    private CheckBalance checkBalance;
    private Transactions transactions;
    private UserAuthentication userAuth; 

    public CashTransfer(CheckBalance checkBalance, Transactions transactions, UserAuthentication userAuth) {
        this.checkBalance = checkBalance;
        this.transactions = transactions;
        this.userAuth = userAuth;
    }

    public boolean transferCash(int senderUserId, int receiverUserId, double amount) {
        
        if (amount <= 0) {
            System.out.println("Transfer failed: Amount must be positive.");
            return false;
        }
        if (senderUserId == receiverUserId) {
            System.out.println("Transfer failed: Cannot transfer to yourself.");
            return false;
        }

        
        User receiver = userAuth.getUserById(receiverUserId);
        if (receiver == null) {
            System.out.println("Transfer failed: Receiver user ID " + receiverUserId + " does not exist.");
            return false;
        }

       
        double senderBalance = checkBalance.getUserBalance(senderUserId);
        if (senderBalance < amount) {
            System.out.println("Transfer failed: Insufficient balance. Your current balance is " + String.format("%.2f", senderBalance));
            return false;
        }

       
        boolean senderDeducted = checkBalance.updateBalance(senderUserId, -amount);
        if (!senderDeducted) {
            System.out.println("Transfer failed: Problem deducting from sender's balance.");
            return false; 
        }

        boolean receiverAdded = checkBalance.updateBalance(receiverUserId, amount);
        if (!receiverAdded) {
            System.out.println("Transfer failed: Problem adding to receiver's balance. Reverting sender's deduction.");
           
            checkBalance.updateBalance(senderUserId, amount);
            return false;
        }

      
        transactions.recordTransaction(
            new Transaction(transactions.getNextTransactionId(), amount, "Transfer-send", senderUserId, receiverUserId, senderUserId)
        );
        transactions.recordTransaction(
            new Transaction(transactions.getNextTransactionId(), amount, "Transfer-receive", receiverUserId, receiverUserId, senderUserId)
        );

        System.out.println("Transfer successful! " + String.format("%.2f", amount) + " transferred from user ID " + senderUserId + " to user ID " + receiverUserId);
        return true;
    }
}