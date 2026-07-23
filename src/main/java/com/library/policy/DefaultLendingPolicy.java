package com.library.policy;

public class DefaultLendingPolicy implements LendingPolicy {

    private static final int MAXIMUM_BOOKS = 5;
    private static final int LOAN_DURATION_DAYS = 14;

    @Override
    public int getMaximumBooksAllowed() {
        return MAXIMUM_BOOKS;
    }

    @Override
    public int getLoanDurationDays() {
        return LOAN_DURATION_DAYS;
    }
}