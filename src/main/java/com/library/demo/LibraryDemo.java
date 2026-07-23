package com.library.demo;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.Member;
import com.library.policy.DefaultLendingPolicy;
import com.library.service.LibraryService;

public class LibraryDemo {

    public static void main(String[] args) {

        LibraryService library = new LibraryService(new DefaultLendingPolicy());

        library.addBook(
                new Book(
                        "9780132350884",
                        "Clean Code",
                        "Robert C. Martin",
                        2008),
                3
        );

        library.addBook(
                new Book(
                        "9780134685991",
                        "Effective Java",
                        "Joshua Bloch",
                        2018),
                2
        );

        library.registerMember(
                new Member(
                        "M001",
                        "Alice",
                        "alice@gmail.com"
                )
        );

        library.registerMember(
                new Member(
                        "M002",
                        "Bob",
                        "bob@gmail.com"
                )
        );

        System.out.println("-----------------------------------");
        System.out.println("Library Management System Demo");
        System.out.println("-----------------------------------");

        try {

            Loan loan1 = library.borrowBook(
                    "M001",
                    "9780132350884"
            );

            System.out.println("Book Borrowed Successfully!");
            System.out.println(loan1);

            Loan loan2 = library.borrowBook(
                    "M002",
                    "9780134685991"
            );

            System.out.println("\nBook Borrowed Successfully!");
            System.out.println(loan2);

            System.out.println("\nBooks containing 'Java'");

            library.searchByTitle("Java")
                    .forEach(System.out::println);

            library.returnBook(
                    "M001",
                    loan1.getBookCopy().getCopyId()
            );

            System.out.println("\nBook Returned Successfully!");

        } catch (Exception e) {

            System.out.println("\nError : " + e.getMessage());
        }

        System.out.println("-----------------------------------");
        System.out.println("Program Finished");
        System.out.println("-----------------------------------");
    }
}