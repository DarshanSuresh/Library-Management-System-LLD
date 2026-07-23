package com.library.model;

import java.util.Objects;

/**
 * Represents a book in the library catalog.
 * This class stores only the book's metadata.
 */
public class Book {

    private final String isbn;
    private final String title;
    private final String author;
    private final int publicationYear;

    /**
     * Creates a new Book.
     *
     * @param isbn ISBN number
     * @param title Book title
     * @param author Author name
     * @param publicationYear Year of publication
     */
    public Book(String isbn, String title, String author, int publicationYear) {

        this.isbn = Objects.requireNonNull(isbn, "ISBN cannot be null");
        this.title = Objects.requireNonNull(title, "Title cannot be null");
        this.author = Objects.requireNonNull(author, "Author cannot be null");
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "Book {" +
                "ISBN='" + isbn + '\'' +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Publication Year=" + publicationYear +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Book))
            return false;

        Book other = (Book) obj;

        return isbn.equals(other.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }
}