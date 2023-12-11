package com.pingwit.financialTrackerApp.exception;

public class CategoryExistsException extends Exception{
    public CategoryExistsException(String message) {
        super(message);
    }

    public CategoryExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}