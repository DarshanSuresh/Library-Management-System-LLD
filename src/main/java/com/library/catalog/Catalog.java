package com.library.catalog;

import com.library.exception.BookNotFoundException;
import com.library.model.Book;
import com.library.model.BookCopy;

import java.util.*;

public class Catalog {

    private final Map<String, Book> books;
    private final Map<String, List<BookCopy>> bookCopies;
    private final Map<String, BookCopy> copyIndex;

    public Catalog() {
        books = new HashMap<>();
        bookCopies = new HashMap<>();
        copyIndex = new HashMap<>();
    }

    public void addBook(Book book, int numberOfCopies) {

        books.putIfAbsent(book.getIsbn(), book);

        List<BookCopy> copies =
                bookCopies.computeIfAbsent(book.getIsbn(),
                        k -> new ArrayList<>());

        for (int i = 1; i <= numberOfCopies; i++) {

            String copyId = book.getIsbn() + "-COPY-" + UUID.randomUUID();

            BookCopy copy = new BookCopy(copyId, book);

            copies.add(copy);

            copyIndex.put(copyId, copy);
        }
    }

    public Book getBook(String isbn) {

        Book book = books.get(isbn);

        if (book == null) {
            throw new BookNotFoundException(isbn);
        }

        return book;
    }

    public List<BookCopy> getCopies(String isbn) {

        getBook(isbn);

        return bookCopies.get(isbn);
    }

    public BookCopy getAvailableCopy(String isbn) {

        List<BookCopy> copies = getCopies(isbn);

        for (BookCopy copy : copies) {

            if (copy.isAvailable()) {
                return copy;
            }
        }

        return null;
    }

    public BookCopy getCopyById(String copyId) {

        BookCopy copy = copyIndex.get(copyId);

        if (copy == null) {
            throw new BookNotFoundException(copyId);
        }

        return copy;
    }

    public List<Book> searchByTitle(String keyword) {

        List<Book> result = new ArrayList<>();

        for (Book book : books.values()) {

            if (book.getTitle().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                result.add(book);
            }
        }

        return result;
    }

    public void removeCopy(String copyId) {

        BookCopy copy = getCopyById(copyId);

        List<BookCopy> copies =
                bookCopies.get(copy.getBook().getIsbn());

        copies.remove(copy);

        copyIndex.remove(copyId);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}