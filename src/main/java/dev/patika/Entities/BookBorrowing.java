package dev.patika.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book_borrowing")
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrower_id", unique = true, nullable = false)
    private int borrowerId;

    @Column(name = "borrower_name")
    private String borrowerName;

    @Column(name = "borrower_date", length = 100, nullable = false)
    private LocalDate borrowerDate;

    @Column(name = "borrower_return_date")
    private LocalDate  borrowerReturnDate;

    @OneToMany(mappedBy = "bookBorrowing", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> bookList;



    public BookBorrowing() {
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public LocalDate getBorrowerDate() {
        return borrowerDate;
    }

    public void setBorrowerDate(LocalDate borrowerDate) {
        this.borrowerDate = borrowerDate;
    }

    public LocalDate getBorrowerReturnDate() {
        return borrowerReturnDate;
    }

    public void setBorrowerReturnDate(LocalDate borrowerReturnDate) {
        this.borrowerReturnDate = borrowerReturnDate;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
