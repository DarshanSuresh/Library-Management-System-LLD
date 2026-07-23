package com.library.policy;

/**
 * Defines the borrowing rules for the library.
 * Different implementations can have different limits and loan durations.
 */
public interface LendingPolicy {

    /**
     * Returns the maximum number of books
     * a member can borrow simultaneously.
     *
     * @return maximum concurrent loans
     */
    int getMaximumBooksAllowed();

    /**
     * Returns the number of days
     * a member can keep a borrowed book.
     *
     * @return loan duration in days
     */
    int getLoanDurationDays();
}