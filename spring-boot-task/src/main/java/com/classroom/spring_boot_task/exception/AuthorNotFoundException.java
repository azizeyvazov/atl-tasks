package com.classroom.spring_boot_task.exception;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(String message) {
        super(message);
    }
}
