package com.orange.demo.exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String errorMessage) {
        super("User not found");
    }
}
