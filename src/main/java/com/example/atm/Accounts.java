package com.example.atm;

public class Accounts {
    private static String[] accountUser = new String[100];
    private static String[] accountPass = new String[100];
    private static int count = 0;


    public static void addAccount(String username, String password) {
        accountUser[count] = username;
        accountPass[count] = password;
        count++;
    }

    public static boolean checkAvaliability(String username) {
        if (accountUser.length >= 0 && accountPass.length >= 0) {
            for (String user : accountUser) {
                if(user == null) {
                    return true;
                }
                if (user.equals(username)) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    public static String createAccount(String username, String password) {
        checkAvaliability(username);
        if (checkAvaliability(username) == false) {
            return "Username already taken. Please choose a new one";
        } else {
            addAccount(username, password);
            return "Account created. Return and log in";
        }
    }
}
