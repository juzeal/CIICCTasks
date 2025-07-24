package com.gcashapp;

import java.util.ArrayList;
import java.util.List;

public class UserAuthentication {
    private List<User> users; 
    private int nextUserId = 1001; 

    public UserAuthentication() {
        this.users = new ArrayList<>();
        // testing lang ng dummy
        registerUser("John Doe", "john@example.com", "09171234567", "1234");
        registerUser("Jane Smith", "jane@example.com", "09177654321", "5678");
    }

    
    public User registerUser(String name, String email, String number, String pin) {
        
        if (emailExists(email)) {
            System.out.println("Registration failed: Email already registered.");
            return null;
        }
        if (numberExists(number)) {
            System.out.println("Registration failed: Phone number already registered.");
            return null;
        }
        if (pin.length() != 4 || !pin.matches("\\d+")) {
            System.out.println("Registration failed: PIN must be a 4-digit number.");
            return null;
        }
        if (name.isEmpty() || email.isEmpty() || number.isEmpty()) {
            System.out.println("Registration failed: All fields must be filled.");
            return null;
        }

        User newUser = new User(nextUserId++, name, email, number, pin);
        users.add(newUser);
        System.out.println("User registered successfully! User ID: " + newUser.getId());
        return newUser;
    }

    private boolean emailExists(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    private boolean numberExists(String number) {
        for (User user : users) {
            if (user.getNumber().equals(number)) {
                return true;
            }
        }
        return false;
    }

    
    public User login(String emailOrNumber, String pin) {
        for (User user : users) {
            if ((user.getEmail().equalsIgnoreCase(emailOrNumber) || user.getNumber().equals(emailOrNumber)) && user.getPin().equals(pin)) {
                System.out.println("Login successful for user: " + user.getName());
                return user; 
            }
        }
     
        System.out.println("Login failed: Invalid email/number or PIN.");
        return null;
    }

   
    public boolean changePin(int userId, String oldPin, String newPin) {
        User userToUpdate = null;
        for (User user : users) {
            if (user.getId() == userId) {
                userToUpdate = user;
                break;
            }
        }

        if (userToUpdate == null) {
            System.out.println("Change PIN failed: User not found.");
            return false;
        }

        if (!userToUpdate.getPin().equals(oldPin)) {
            System.out.println("Change PIN failed: Old PIN is incorrect.");
            return false;
        }

        if (newPin.length() != 4 || !newPin.matches("\\d+")) {
            System.out.println("Change PIN failed: New PIN must be a 4-digit number.");
            return false;
        }

        userToUpdate.setPin(newPin);
        System.out.println("PIN changed successfully for user ID: " + userId);
        return true;
    }


    public void logout(User loggedInUser) {
        if (loggedInUser != null) {
            System.out.println("User " + loggedInUser.getName() + " logged out successfully.");
        } else {
            System.out.println("No user was logged in.");
        }
    }


    public User getUserById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    
    public void listAllUsers() {
        System.out.println("\n--- All Registered Users ---");
        if (users.isEmpty()) {
            System.out.println("No users registered yet.");
            return;
        }
        for (User user : users) {
            System.out.println(user.toString());
        }
        System.out.println("----------------------------\n");
    }
}