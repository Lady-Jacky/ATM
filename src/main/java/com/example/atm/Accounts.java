package com.example.atm;

public class Accounts {
    private static String[] accountUser = new String[100];
    private static String[] accountPass = new String[100];
    private static double[] userSavings = new double[100];
    private static double[] userChecks = new double[100];
    private static int count = 0;
    private static String currentUser = "";


    public static void addAccount(String username, String password) {
        accountUser[count] = username;
        accountPass[count] = password;
        userSavings[count] = 0.0;
        userChecks[count] = 0.0;
        count++;
    }

    public static double getUserSavings() {
        return userSavings[findUser()];
    }
    public static String getCurrentUser() {
        return currentUser;
    }

    private static int findUser() {
        for (int i = 0; i < accountUser.length; i++) {
            if (accountUser[i] != null && accountUser[i].equals(currentUser)) {
                return i;
            }
        }
        return 0;
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

    public static boolean checkInfo(String username, String password) {
        if (accountUser.length >= 0 && accountPass.length >= 0) {
            for (int i = 0; i < accountUser.length; i++) {
                if(accountUser[i] != null && accountUser[i].equals(username)) {
                    if(password.equals(accountPass[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public static String createAccount(String username, String password) {
        checkAvaliability(username);
        if (checkAvaliability(username) == false) {
            return "Username already taken. Please choose\na new one";
        }else if ((username.equals("") || password.equals(""))) {
            return "Username and password cannot be left blank.";
        } else {
            addAccount(username, password);
            return "Account created. Return and log in";
        }
    }

    public static String checkLogIn(String username, String password) {
        if ((username.equals("") || password.equals(""))) {
            return "Username and password cannot be left blank.";
        } else if (checkInfo(username, password) == false) {
            return "Either username or password is wrong.";
        }
        currentUser = username;
        return "You are now logged in";
    }
}
