package com.library.exception;

public class BorrowLimitExceededException extends LibraryException {

    public BorrowLimitExceededException(String memberId, int limit) {

        super("Member " + memberId +
                " has already borrowed the maximum allowed books (" +
                limit + ").");
    }
}