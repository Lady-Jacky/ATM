package com.example.atm;

public class Accounts {
    private static String[] accountUser = new String[100];
    private static String[] accountPass = new String[100];
    private static int count = 0;
    private static String username;
    private static String password;

    public Accounts(String username, String password) {
        this.username = username;
        this.password = password;
        accountUser[1] = "";
    }

    public void setAccount(String user, String pass) {
        username = user;
        password = pass;
    }

    public static void addAccount() {
        accountUser[count] = username;
        accountPass[count] = password;
        count++;
    }

    public static boolean checkAvaliability() {
        if (accountUser.length > 0 && accountPass.length > 0) {
            for (int i = 0; i < accountUser.length; i++) {
                if (accountUser[i].equals(username)) {
                    return false;
                }
            }
            addAccount();
            return true;
        } else {
            addAccount();
            return true;
        }
    }

    public static String createAccount(String username, String password) {
        checkAvaliability();
        if (checkAvaliability() == true) {
            return "Account created, return to previous page and log in";
        } else {
            return "Username already taken. Please choose a new one";
        }
    }
}
