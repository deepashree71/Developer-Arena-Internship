package library;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = FileHandler.loadBooks();
        members = FileHandler.loadMembers();
    }

    public void addBook(Book book) {
        books.add(book);
        FileHandler.saveBooks(books);
        System.out.println("Book added successfully.");
    }

    public void viewBooks() {
        System.out.println("\n=== ALL BOOKS ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void registerMember(Member member) {
        members.add(member);
        FileHandler.saveMembers(members);
        System.out.println("Member registered successfully.");
    }

    public void borrowBook(String isbn, String memberId) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                book.borrowBook(memberId);
                FileHandler.saveBooks(books);
                System.out.println("Book borrowed successfully.");
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isAvailable()) {
                book.returnBook();
                FileHandler.saveBooks(books);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("Invalid return.");
    }

    public void showStatistics() {
        int available = 0;
        int borrowed = 0;

        for (Book book : books) {
            if (book.isAvailable())
                available++;
            else
                borrowed++;
        }

        System.out.println("\n=== LIBRARY STATISTICS ===");
        System.out.println("Total Books: " + books.size());
        System.out.println("Available Books: " + available);
        System.out.println("Borrowed Books: " + borrowed);
        System.out.println("Registered Members: " + members.size());
    }
}
