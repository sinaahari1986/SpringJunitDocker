package com.sadad.spring.exceptions;

public class UsersServiceException extends RuntimeException{
    public UsersServiceException(String message)
    {
        super(message);
    }
}