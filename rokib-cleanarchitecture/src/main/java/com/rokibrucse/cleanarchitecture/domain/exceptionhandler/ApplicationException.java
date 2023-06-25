package com.rokibrucse.cleanarchitecture.domain.exceptionhandler;
public class ApplicationException extends Exception {
    public ApplicationException(String message) {
        super(message);
    }
}
