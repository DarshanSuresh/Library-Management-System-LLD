package com.library.exception;

public class InvalidReturnException extends LibraryException {

    public InvalidReturnException(String memberId, String copyId) {

        super("Member " + memberId +
                " has not borrowed copy: " + copyId);
    }
}