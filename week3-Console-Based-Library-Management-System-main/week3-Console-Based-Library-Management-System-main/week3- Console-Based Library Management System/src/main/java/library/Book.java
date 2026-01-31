package library;

import java.io.Serializable;

public class Book implements Serializable {

    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean available;
    private String borrowedBy;

    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
        this.borrowedBy = "None";
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

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    public void borrowBook(String memberId) {
        this.available = false;
        this.borrowedBy = memberId;
    }

    public void returnBook() {
        this.available = true;
        this.borrowedBy = "None";
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + " | Title: " + title +
                " | Author: " + author + " | Year: " + year +
                (available ? " | Available" : " | Borrowed by: " + borrowedBy);
    }
}
