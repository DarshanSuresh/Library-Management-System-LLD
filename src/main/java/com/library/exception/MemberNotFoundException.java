package com.library.exception;

/**
 * Thrown when a member cannot be found.
 */
public class MemberNotFoundException extends LibraryException {

    public MemberNotFoundException(String memberId) {
        super("Member not found: " + memberId);
    }
}