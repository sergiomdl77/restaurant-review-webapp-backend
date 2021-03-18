package com.delgadotw.myfirstwebapp.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(String message)
    {
        super(message);
    }
}
