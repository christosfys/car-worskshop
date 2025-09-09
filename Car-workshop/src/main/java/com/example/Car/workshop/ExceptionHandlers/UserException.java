package com.example.Car.workshop.ExceptionHandlers;

public class UserException extends RuntimeException {

    public UserException(String name) {
        super("A user with the name '" + name + "' already exists.");
    }
}
