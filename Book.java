import java.util.Scanner;

public class Book implements Displayable {
    private String bookType;
    private String title;
    private String author;
    private String ISBN;
    protected boolean avalabilityStatus;
    public static Scanner reader = new Scanner(System.in);

    public Book(String bookType, String title, String author, String ISBN, boolean avalabilityStatus) {
        this.bookType = bookType;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.avalabilityStatus = avalabilityStatus;
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
        for (Book book : Library.bookCollection) {
            if (book.getBookType().equals(bookType)) {
                book.toString(book.getTitle(), book.getAuthor(), book.getISBN(), book.getAvalabilityStatus());
            }
        }
    }

    @Override
    public void toString(String title, String author, String ISBN, boolean availabilityStatus) {
        System.out.println("All General Books in Library");
        System.out.println(" Title: " + title + ", Author: " + author + ", ISBN: " + ISBN
                + ", Can Borrow: " + avalabilityStatus);

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

    public void setAvailabilityStatus(boolean avalabilityStatus) {
        this.avalabilityStatus = avalabilityStatus;
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

    public boolean getAvalabilityStatus() {
        return avalabilityStatus;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public boolean isAvalabilityStatus() {
        return avalabilityStatus;
    }

}