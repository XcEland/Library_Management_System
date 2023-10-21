import java.util.Scanner;

public class Book implements Displayable {
    private String bookType;
    private String title;
    private String author;
    private String ISBN;
    protected boolean availabilityStatus;
    public static Scanner reader = new Scanner(System.in);

    public Book(String bookType, String title, String author, String ISBN, boolean availabilityStatus) {
        this.bookType = bookType;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availabilityStatus = availabilityStatus;
    }

    public static void displayLibraryBooks() {
        System.out.println("Enter book type (A/C/S):");
        String bookType = reader.nextLine();
        if (bookType.equalsIgnoreCase("A")) {
            returnBooks(bookType);
        } else if (bookType.equalsIgnoreCase("C")) {
            returnBooks(bookType);
        } else if (bookType.equalsIgnoreCase("S")) {
            returnBooks(bookType);
        }
    }

    public static void returnBooks(String bookType) {
        if (Library.bookCollection == null) {
            System.out.println("No books available in the library");
            return;
        }

        if (Library.bookCollection.isEmpty()) {
            System.out.println("No books of any type available in the library");
            return;
        }

        boolean foundMatchingBooks = false;

        for (Book book : Library.bookCollection) {
            if (book.getBookType().equals(bookType)) {
                foundMatchingBooks = true;
                book.toString(book.getTitle(), book.getAuthor(), book.getISBN(), book.getAvailabilityStatus());
            }
        }

        if (!foundMatchingBooks) {
            System.out.println("No books of type " + bookType + " found in the library");
        }
    }

    @Override
    public void toString(String title, String author, String ISBN, boolean availabilityStatus) {
        System.out.println("All General Books in Library");
        System.out.println(" Title: " + title + ", Author: " + author + ", ISBN: " + ISBN
                + ", Can Borrow: " + availabilityStatus);

    }

    // setters and getters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean getAvailabilityStatus() {
        return availabilityStatus;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public boolean isAvalabilityStatus() {
        return availabilityStatus;
    }

}