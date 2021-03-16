package com.tema10.mvc.exception;

public class CarNotFoundException extends RuntimeException{

    public CarNotFoundException(String message) {
        super(message);
    }
}
