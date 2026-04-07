package com.klef.service;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public String checkStrength(String password) {

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSymbol = password.matches(".*[^A-Za-z0-9].*");

        if (password.length() >= 8 && hasUpper && hasNumber && hasSymbol) {
            return "Strong";
        } else if (password.length() >= 6) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

    public String getSuggestion(String password) {
        StringBuilder suggestion = new StringBuilder();

        if (password.length() < 8) {
            suggestion.append("Use at least 8 characters. ");
        }
        if (!password.matches(".*[A-Z].*")) {
            suggestion.append("Add uppercase letter. ");
        }
        if (!password.matches(".*[0-9].*")) {
            suggestion.append("Add numbers. ");
        }
        if (!password.matches(".*[^A-Za-z0-9].*")) {
            suggestion.append("Add special symbols. ");
        }

        if (suggestion.length() == 0) {
            return "Good password!";
        }

        return suggestion.toString();
    }
}