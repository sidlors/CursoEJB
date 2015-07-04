package com.example.beans;

public class EmployeeException extends Exception {

    public EmployeeException() {
    }

    public EmployeeException(Throwable cause) {
        super(cause);
    }

    public EmployeeException(String reason) {
        super(reason);
    }
}
