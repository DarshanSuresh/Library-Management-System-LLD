package com.library.exception;

public class BookNotFoundException extends LibraryException {

    public BookNotFoundException(String id) {
        super("Book or Copy not found: " + id);
    }
}