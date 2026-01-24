package com.israel.expensemanager.exceptions;

public class InvalidOrExpiredTokenException extends RuntimeException{
    public  InvalidOrExpiredTokenException(String message) { super(message); }
}
