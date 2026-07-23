package com.library.service;

import com.library.catalog.Catalog;
import com.library.exception.BookUnavailableException;
import com.library.exception.BorrowLimitExceededException;
import com.library.exception.InvalidReturnException;
import com.library.exception.MemberNotFoundException;
import com.library.model.Book;
import com.library.model.BookCopy;
import com.library.model.Loan;
import com.library.model.Member;
import com.library.policy.LendingPolicy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {

    private final Catalog catalog;
    private final LendingPolicy policy;
    private final Map<String, Member> members;

    public LibraryService(LendingPolicy policy) {
        this.catalog = new Catalog();
        this.policy = policy;
        this.members = new HashMap<>();
    }

    public void registerMember(Member member) {

        members.put(member.getMemberId(), member);
    }

    public void addBook(Book book, int copies) {

        catalog.addBook(book, copies);
    }

    public Loan borrowBook(String memberId, String isbn) {

        Member member = members.get(memberId);

        if (member == null) {
            throw new MemberNotFoundException(memberId);
        }

        if (member.getActiveLoanCount() >=
                policy.getMaximumBooksAllowed()) {

            throw new BorrowLimitExceededException(
                    memberId,
                    policy.getMaximumBooksAllowed()
            );
        }

        BookCopy copy = catalog.getAvailableCopy(isbn);

        if (copy == null) {
            throw new BookUnavailableException(isbn);
        }

        boolean borrowed = copy.borrow();

        if (!borrowed) {
            throw new BookUnavailableException(isbn);
        }

        Loan loan = new Loan(
                copy,
                member,
                policy.getLoanDurationDays()
        );

        member.addLoan(loan);

        return loan;
    }

    public void returnBook(String memberId, String copyId) {

        Member member = members.get(memberId);

        if (member == null) {
            throw new MemberNotFoundException(memberId);
        }

        Loan loan = member.findLoanByCopyId(copyId);

        if (loan == null) {
            throw new InvalidReturnException(memberId, copyId);
        }

        loan.closeLoan();

        loan.getBookCopy().returnBook();

        member.removeLoan(loan);
    }

    public List<Book> searchByTitle(String title) {

        return catalog.searchByTitle(title);
    }

    public Catalog getCatalog() {

        return catalog;
    }

    public Map<String, Member> getMembers() {

        return members;
    }
}