package com.classroom.spring_boot_task.exception;


public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String message) {
        super(message);
    }
}
