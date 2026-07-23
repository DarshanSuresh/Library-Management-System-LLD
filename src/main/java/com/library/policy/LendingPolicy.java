package com.library.policy;

public interface LendingPolicy {

    int getMaximumBooksAllowed();

    int getLoanDurationDays();
}