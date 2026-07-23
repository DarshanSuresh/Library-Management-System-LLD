package com.library.exception;

/**
 * Thrown when a member has reached the borrowing limit.
 */
public class BorrowLimitExceededException extends LibraryException {

    public BorrowLimitExceededException(String memberId, int limit) {

        super("Member " + memberId +
                " has already borrowed the maximum allowed books (" +
                limit + ").");
    }
}