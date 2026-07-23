package com.library.model;

/**
 * Represents a physical copy of a book.
 * Each copy has a unique copy ID and its own availability status.
 */
public class BookCopy {

    private final String copyId;
    private final Book book;
    private BookStatus status;

    /**
     * Creates a new physical book copy.
     *
     * @param copyId Unique copy identifier
     * @param book Associated book
     */
    public BookCopy(String copyId, Book book) {
        this.copyId = copyId;
        this.book = book;
        this.status = BookStatus.AVAILABLE;
    }

    /**
     * Attempts to borrow this copy.
     *
     * @return true if borrowing succeeds, false otherwise
     */
    public synchronized boolean borrow() {

        if (status != BookStatus.AVAILABLE) {
            return false;
        }

        status = BookStatus.BORROWED;
        return true;
    }

    /**
     * Returns the book copy.
     */
    public synchronized void returnBook() {

        if (status == BookStatus.BORROWED) {
            status = BookStatus.AVAILABLE;
        }
    }

    /**
     * Marks the copy as lost.
     */
    public synchronized void markLost() {
        status = BookStatus.LOST;
    }

    public String getCopyId() {
        return copyId;
    }

    public Book getBook() {
        return book;
    }

    public BookStatus getStatus() {
        return status;
    }

    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "copyId='" + copyId + '\'' +
                ", title='" + book.getTitle() + '\'' +
                ", status=" + status +
                '}';
    }
}