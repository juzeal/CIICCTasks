package com.gcashapp;

import java.util.List;
import java.util.Scanner;

public class GcahApp {

    private UserAuthentication userAuth;
    private CheckBalance checkBalance;
    private Cashin cashInService;
    private CashTransfer cashTransferService;
    private Transactions transactionsService;

    private User currentUser = null; 
    private Scanner scanner;

    public GcahApp() {
        userAuth = new UserAuthentication();
        checkBalance = new CheckBalance();
        transactionsService = new Transactions(); 
        cashInService = new Cashin(checkBalance, transactionsService);
        cashTransferService = new CashTransfer(checkBalance, transactionsService, userAuth);
        scanner = new Scanner(System.in);

       
        if (userAuth.getUserById(1001) != null) {
            checkBalance.addInitialBalance(1001, 500.00); 
        }
        if (userAuth.getUserById(1002) != null) {
            checkBalance.addInitialBalance(1002, 250.00);
        }
    }

    public static void main(String[] args) {
        GcahApp app = new GcahApp();
        app.run();
    }

    public void run() {
        System.out.println("Welcome to GCash App!");

        
        userAuth.listAllUsers();
        checkBalance.listAllBalances();

        while (true) {
            if (currentUser == null) {
                showLoginMenu();
            } else {
                showMainMenu();
            }
        }
    }

    private void showLoginMenu() {
        System.out.println("\n--- Login / Registration ---");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int choice = getIntegerInput();

        switch (choice) {
            case 1:
                handleLogin();
                break;
            case 2:
                handleRegistration();
                break;
            case 3:
                System.out.println("Thank you for using GCash App. Goodbye!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void handleLogin() {
        System.out.print("Enter Email or Phone Number: ");
        String emailOrNumber = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        currentUser = userAuth.login(emailOrNumber, pin);
        if (currentUser == null) {
            System.out.println("Login attempt failed. Please check your credentials.");
        }
    }

    private void handleRegistration() {
        System.out.println("\n--- User Registration ---");
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone Number (e.g., 09xxxxxxxxx): ");
        String number = scanner.nextLine();
        System.out.print("Enter 4-digit PIN: ");
        String pin = scanner.nextLine();

        User newUser = userAuth.registerUser(name, email, number, pin);
        if (newUser != null) {
            
            checkBalance.addInitialBalance(newUser.getId(), 0.0); 
            System.out.println("Registration successful! You can now log in.");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }


    private void showMainMenu() {
        System.out.println("\n--- Welcome, " + currentUser.getName() + " ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Cash-in");
        System.out.println("3. Cash Transfer");
        System.out.println("4. View Transactions");
        System.out.println("5. Change PIN");
        System.out.println("6. Logout");
        System.out.print("Choose an option: ");
        int choice = getIntegerInput();

        switch (choice) {
            case 1:
                double balance = checkBalance.getUserBalance(currentUser.getId());
                System.out.println("Your current balance: Php " + String.format("%.2f", balance));
                break;
            case 2:
                handleCashIn();
                break;
            case 3:
                handleCashTransfer();
                break;
            case 4:
                handleViewTransactions();
                break;
            case 5:
                handleChangePin();
                break;
            case 6:
                userAuth.logout(currentUser);
                currentUser = null;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void handleCashIn() {
        System.out.print("Enter amount to cash-in: ");
        double amount = getDoubleInput();
        if (amount > 0) {
            cashInService.cashIn(currentUser.getId(), amount);
        } else {
            System.out.println("Invalid amount. Amount must be positive.");
        }
    }

    private void handleCashTransfer() {
        System.out.print("Enter receiver's User ID: ");
        int receiverId = getIntegerInput();
        System.out.print("Enter amount to transfer: ");
        double amount = getDoubleInput();

        cashTransferService.transferCash(currentUser.getId(), receiverId, amount);
    }

    private void handleViewTransactions() {
        System.out.println("\n--- View Transactions ---");
        System.out.println("1. View all my transactions");
        System.out.println("2. View a specific transaction by ID");
        System.out.print("Choose an option: ");
        int choice = getIntegerInput();

        switch (choice) {
            case 1:
                List<Transaction> userTransactions = transactionsService.viewUserTransactions(currentUser.getId());
                if (userTransactions.isEmpty()) {
                    System.out.println("No transactions found for your account.");
                } else {
                    System.out.println("\n--- Your Transactions ---");
                    for (Transaction t : userTransactions) {
                        System.out.println(t);
                    }
                    System.out.println("--------------------------");
                }
                break;
            case 2:
                System.out.print("Enter Transaction ID: ");
                int transactionId = getIntegerInput();
                Transaction transaction = transactionsService.viewTransactionById(transactionId);
                if (transaction != null) {
                    System.out.println("\n--- Transaction Details ---");
                    System.out.println(transaction);
                    System.out.println("---------------------------");
                } else {
                    System.out.println("Transaction with ID " + transactionId + " not found.");
                }
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void handleChangePin() {
        System.out.print("Enter current PIN: ");
        String oldPin = scanner.nextLine();
        System.out.print("Enter new 4-digit PIN: ");
        String newPin = scanner.nextLine();

        userAuth.changePin(currentUser.getId(), oldPin, newPin);
    }


    
    private int getIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); 
            System.out.print("Enter choice: ");
        }
        int input = scanner.nextInt();
        scanner.nextLine(); 
        return input;
    }

    
    private double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); 
            System.out.print("Enter amount: ");
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); 
        return input;
    }
}