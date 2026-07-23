package com.library.exception;

public class MemberNotFoundException extends LibraryException {

    public MemberNotFoundException(String memberId) {
        super("Member not found: " + memberId);
    }
}