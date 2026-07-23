package com.library.exception;

/**
 * Thrown when a member attempts to return
 * a book that was never borrowed.
 */
public class InvalidReturnException extends LibraryException {

    public InvalidReturnException(String memberId, String copyId) {

        super("Member " + memberId +
                " has not borrowed copy: " + copyId);
    }
}