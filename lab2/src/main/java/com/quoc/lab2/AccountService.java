/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quoc.lab2;

/**
 *
 * @author ASUS PC
 */
import java.util.regex.Pattern;

public class AccountService {

    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.trim().isEmpty()) {
            return false;
        }
        if (password == null || password.length() <= 6) {
            return false;
        }
        if (!isValidEmail(email)) {
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }
}
