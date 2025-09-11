package com.example.Car.workshop.ExceptionHandlers;

public class UserException extends RuntimeException {

    public UserException(String name) {
        super("The user hasnt found");
    }
    
}
