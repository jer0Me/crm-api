package com.crmapi.exceptions;

public class UserRequestException extends RuntimeException {

    public UserRequestException(String message) {
        super(message);
    }
}
