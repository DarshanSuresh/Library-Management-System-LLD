package com.library.model;

public class BookCopy {

    private final String copyId;
    private final Book book;
    private BookStatus status;

    public BookCopy(String copyId, Book book) {
        this.copyId = copyId;
        this.book = book;
        this.status = BookStatus.AVAILABLE;
    }

    public synchronized boolean borrow() {

        if (status != BookStatus.AVAILABLE) {
            return false;
        }

        status = BookStatus.BORROWED;
        return true;
    }

    public synchronized void returnBook() {

        if (status == BookStatus.BORROWED) {
            status = BookStatus.AVAILABLE;
        }
    }

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