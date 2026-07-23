package com.library.exception;

/**
 * Thrown when all copies of a book are already borrowed.
 */
public class BookUnavailableException extends LibraryException {

    public BookUnavailableException(String isbn) {
        super("No available copies for ISBN: " + isbn);
    }
}