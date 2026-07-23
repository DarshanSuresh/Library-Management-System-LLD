package com.library.exception;

/**
 * Thrown when a book or book copy cannot be found.
 */
public class BookNotFoundException extends LibraryException {

    public BookNotFoundException(String id) {
        super("Book or Copy not found: " + id);
    }
}