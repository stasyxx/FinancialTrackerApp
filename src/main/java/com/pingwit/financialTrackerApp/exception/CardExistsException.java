package com.pingwit.financialTrackerApp.exception;

public class CardExistsException extends Exception {

        public CardExistsException(String message) {
            super(message);
        }

        public CardExistsException(String message, Throwable cause) {
            super(message, cause);
        }
    }

