package com.codewithraj.blog.blogappapis.exception;

public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);
    }

    public ApiException() {
    }
}
