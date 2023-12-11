package com.pingwit.financialTrackerApp.exception;

public class ExpenseNotFoundException extends Exception {

    public ExpenseNotFoundException(String message) {
        super(message);
    }

    public ExpenseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}