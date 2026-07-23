package com.library.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a library member.
 */
public class Member {

    private final String memberId;
    private final String name;
    private final String contact;

    private final List<Loan> activeLoans;
    private final List<Loan> loanHistory;

    /**
     * Creates a new library member.
     *
     * @param memberId Unique member ID
     * @param name Member name
     * @param contact Contact information
     */
    public Member(String memberId, String name, String contact) {
        this.memberId = memberId;
        this.name = name;
        this.contact = contact;

        this.activeLoans = new ArrayList<>();
        this.loanHistory = new ArrayList<>();
    }

    /**
     * Adds a new active loan.
     */
    public synchronized void addLoan(Loan loan) {
        activeLoans.add(loan);
        loanHistory.add(loan);
    }

    /**
     * Removes a loan from active loans.
     */
    public synchronized void removeLoan(Loan loan) {
        activeLoans.remove(loan);
    }

    /**
     * Returns the number of active loans.
     */
    public synchronized int getActiveLoanCount() {
        return activeLoans.size();
    }

    /**
     * Checks whether this member has borrowed a copy.
     */
    public synchronized Loan findLoanByCopyId(String copyId) {

        for (Loan loan : activeLoans) {

            if (loan.getBookCopy().getCopyId().equals(copyId)) {
                return loan;
            }
        }

        return null;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    /**
     * Returns all active loans.
     */
    public List<Loan> getActiveLoans() {
        return Collections.unmodifiableList(activeLoans);
    }

    /**
     * Returns complete borrowing history.
     */
    public List<Loan> getLoanHistory() {
        return Collections.unmodifiableList(loanHistory);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", activeLoans=" + activeLoans.size() +
                '}';
    }
}