package com.library.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Represents a borrowing transaction in the library.
 */
public class Loan {

    private final String loanId;
    private final BookCopy bookCopy;
    private final Member member;

    private final LocalDate borrowDate;
    private final LocalDate dueDate;

    private LocalDate returnDate;

    /**
     * Creates a new loan.
     *
     * @param bookCopy Borrowed book copy
     * @param member Borrowing member
     * @param loanDays Loan duration in days
     */
    public Loan(BookCopy bookCopy, Member member, int loanDays) {

        this.loanId = UUID.randomUUID().toString();
        this.bookCopy = bookCopy;
        this.member = member;

        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(loanDays);

        this.returnDate = null;
    }

    /**
     * Marks this loan as returned.
     */
    public void closeLoan() {

        if (returnDate == null) {
            returnDate = LocalDate.now();
        }
    }

    /**
     * Checks whether the loan is still active.
     *
     * @return true if active
     */
    public boolean isActive() {
        return returnDate == null;
    }

    /**
     * Checks whether the loan is overdue.
     *
     * @return true if overdue
     */
    public boolean isOverdue() {
        return isActive() && LocalDate.now().isAfter(dueDate);
    }

    public String getLoanId() {
        return loanId;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public String toString() {

        return "Loan{" +
                "loanId='" + loanId + '\'' +
                ", member='" + member.getName() + '\'' +
                ", book='" + bookCopy.getBook().getTitle() + '\'' +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}