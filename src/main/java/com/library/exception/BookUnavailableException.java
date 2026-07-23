package com.library.exception;

public class BookUnavailableException extends LibraryException {

    public BookUnavailableException(String isbn) {
        super("No available copies for ISBN: " + isbn);
    }
}