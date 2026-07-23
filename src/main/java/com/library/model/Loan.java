package com.library.model;

import java.time.LocalDate;
import java.util.UUID;

public class Loan {

    private final String loanId;
    private final BookCopy bookCopy;
    private final Member member;

    private final LocalDate borrowDate;
    private final LocalDate dueDate;

    private LocalDate returnDate;

    public Loan(BookCopy bookCopy, Member member, int loanDays) {

        this.loanId = UUID.randomUUID().toString();
        this.bookCopy = bookCopy;
        this.member = member;

        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(loanDays);

        this.returnDate = null;
    }

    public void closeLoan() {

        if (returnDate == null) {
            returnDate = LocalDate.now();
        }
    }

    public boolean isActive() {
        return returnDate == null;
    }

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