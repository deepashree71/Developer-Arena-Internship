package library;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveBooks(ArrayList<Book> books) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("books.txt"))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Error saving books file.");
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Book> loadBooks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.txt"))) {
            return (ArrayList<Book>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveMembers(ArrayList<Member> members) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("members.txt"))) {
            oos.writeObject(members);
        } catch (IOException e) {
            System.out.println("Error saving members file.");
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Member> loadMembers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("members.txt"))) {
            return (ArrayList<Member>) ois.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
