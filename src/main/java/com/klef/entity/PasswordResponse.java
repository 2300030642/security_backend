package com.klef.entity;

public class PasswordResponse {
    private String strength;
    private String message;

    public PasswordResponse(String strength, String message) {
        this.strength = strength;
        this.message = message;
    }

    public String getStrength() {
        return strength;
    }

    public String getMessage() {
        return message;
    }
}
