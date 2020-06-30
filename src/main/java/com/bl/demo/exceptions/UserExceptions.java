package com.bl.demo.exceptions;

/**
 * purpose:handling runtime exceptions
 */
public class UserExceptions extends RuntimeException {
    public String message;
    public UserExceptions(String message) {
        this.message=message;
    }
}
