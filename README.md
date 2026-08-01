# Library Management System (Low-Level Design) 

A Java-based **Library Management System** designed using **Object-Oriented Programming (OOP)** and **Low-Level Design (LLD)** principles. The project models real-world library operations such as book management, member registration, book borrowing, and returning while maintaining clean architecture and separation of responsibilities.

---

# Problem Statement

Design and implement a Library Management System that supports:

- Add and manage books
- Register and manage members
- Issue books to members
- Return books
- Track book availability
- Prevent issuing unavailable books

The solution should demonstrate proper **Low-Level Design**, **SOLID principles**, and **clean object-oriented design**. :contentReference[oaicite:1]{index=1}

---

# Features

- Add books with multiple physical copies
- Register library members
- Borrow available books
- Return borrowed books
- Search books by title
- Track book availability
- Custom exception handling
- Modular architecture following LLD principles

---

# Project Structure

```
Library-Management-System-LLD
│
├── README.md
│
└── src
    └── main
        └── java
            └── com
                └── library
                    ├── catalog
                    ├── demo
                    ├── exception
                    ├── model
                    ├── policy
                    └── service
```

---

# Package Description

### model

Contains all core entities.

- Book
- BookCopy
- BookStatus
- Loan
- Member

---

### catalog

Responsible for maintaining the library inventory.

- Stores books
- Stores physical copies
- Searches books
- Finds available copies

---

### service

Contains the business logic.

- Register members
- Borrow books
- Return books
- Apply lending policies
- Coordinate library operations

---

### policy

Contains borrowing rules.

- Maximum books allowed
- Loan duration

Current default policy:

- Maximum Books: **5**
- Loan Duration: **14 Days**

---

### exception

Contains custom exceptions for clean error handling.

- LibraryException
- BookNotFoundException
- BookUnavailableException
- BorrowLimitExceededException
- MemberNotFoundException
- InvalidReturnException

---

### demo

Contains the main class used to demonstrate the application.

---

# Class Responsibilities

| Class | Responsibility |
|-------|----------------|
| Book | Stores book metadata |
| BookCopy | Represents a physical copy of a book |
| Member | Stores member details and borrowing history |
| Loan | Represents a borrowing transaction |
| Catalog | Manages books and copies |
| LendingPolicy | Defines borrowing rules |
| DefaultLendingPolicy | Default implementation of borrowing rules |
| LibraryService | Main service coordinating all operations |
| LibraryDemo | Demonstrates application usage |

---

# Object-Oriented Principles Used

- Encapsulation
- Abstraction
- Composition
- Association
- Separation of Responsibilities

---

# SOLID Principles

- **S** – Single Responsibility Principle
- **O** – Open/Closed Principle
- **L** – Liskov Substitution Principle
- **I** – Interface Segregation Principle
- **D** – Dependency Inversion Principle

---

# Design Patterns

### Facade Pattern

`LibraryService` acts as a single entry point for all library operations.

### Strategy Pattern

`LendingPolicy` allows different borrowing policies without modifying existing code.

---

# Borrow Book Workflow

```
Member
   │
   ▼
Validate Member
   │
   ▼
Check Borrow Limit
   │
   ▼
Find Available Copy
   │
   ▼
Issue Book
   │
   ▼
Create Loan
   │
   ▼
Update Member Records
```

---

# Return Book Workflow

```
Member
   │
   ▼
Find Active Loan
   │
   ▼
Close Loan
   │
   ▼
Return Book Copy
   │
   ▼
Update Member Records
```

---

# Technologies Used

- Java 17 (or Java 11+)
- Object-Oriented Programming
- Java Collections Framework
- UUID
- LocalDate API

---

# How to Run

## Compile

```bash
javac -d out $(find src/main/java -name "*.java")
```

## Run

```bash
java -cp out com.library.demo.LibraryDemo
```

---

# Sample Output

```
-----------------------------------
Library Management System Demo
-----------------------------------

Book Borrowed Successfully!

Loan{...}

Book Borrowed Successfully!

Loan{...}

Books containing 'Java'

Book{ISBN='9780134685991', Title='Effective Java'}

Book Returned Successfully!

-----------------------------------
Program Finished
-----------------------------------
```

---

# Learning Outcomes

This project demonstrates:

- Low-Level System Design
- Object-Oriented Design
- SOLID Principles
- Design Patterns
- Exception Handling
- Modular Java Development

---

# Author

**Darshan Suresh**

MCA (Cybersecurity)

Amrita Vishwa Vidyapeetham

---

# License

This project is developed for educational purposes as part of the **Low-Level Design (LLD)** assignment.
