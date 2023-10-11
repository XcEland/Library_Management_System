import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    static ArrayList<Book> bookCollection;
    public static Scanner reader = new Scanner(System.in);

    public static String addBook() {
        System.out.println("Enter Book Type(A/C/S):");
        String bookType = reader.nextLine();

        System.out.println("Enter title:");
        String title = reader.nextLine();

        System.out.println("Enter author:");
        String author = reader.nextLine();

        System.out.println("Enter ISBN:");
        String ISBN = reader.nextLine();

        String message = "";
        // check if book is already in library
        boolean availabilityStatus = checkAvailability(ISBN);
        if (availabilityStatus) {
            message += "Book already added.";
        } else {
            // add book
            availabilityStatus = true;
            Book book;
            if (bookType.equals("A")) {
                book = new Art(title, author, ISBN, availabilityStatus);
            } else if (bookType.equals("C")) {
                book = new Commercial(title, author, ISBN, availabilityStatus);
            } else if (bookType.equals("S")) {
                book = new Science(title, author, ISBN, availabilityStatus);
            } else {
                book = new Book(title, author, ISBN, availabilityStatus);
            }
            bookCollection.add(book);
            message += "Book added successfully.";
        }
        return message;

    }

    public static String removeBook() {
        System.out.println("Enter ISBN:");
        String ISBN = reader.nextLine();
        String message = "";

        // check if book is already in library
        boolean availabilityStatus = checkAvailability(ISBN);

        if (availabilityStatus) {
            for (Book book : bookCollection) {
                if (book.getISBN().equals(ISBN)) {
                    bookCollection.remove(book);
                    message += "Book removed succesfully";
                }
            }
        } else {
            message += "Book not found";
        }
        return message;
    }

    public static boolean checkAvailability(String ISBN) {
        // check if its already in the collection
        boolean bookAvailability = false;
        for (Book book : bookCollection) {
            if (book.getISBN().equals(ISBN)) {
                bookAvailability = true;
            } else {
                bookAvailability = false;
            }
        }
        return bookAvailability;
    }

}