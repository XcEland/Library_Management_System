import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Library {
    static ArrayList<Book> bookCollection = new ArrayList<Book>();
    public static Scanner reader = new Scanner(System.in);

    public static void addBook() {
        System.out.println("Enter Book Type(A/C/S):");
        String bookType = reader.nextLine();
        System.out.println("Enter title:");
        String title = reader.nextLine();
        System.out.println("Enter author:");
        String author = reader.nextLine();
        System.out.println("Enter ISBN:");
        String ISBN = reader.nextLine();

        boolean availabilityStatus = checkAvailability(ISBN);
        Book book;
        if (availabilityStatus) {
            if (bookType.equalsIgnoreCase("A")) {
                book = new Art(bookType, title, author, ISBN, availabilityStatus);
                System.out.println("Art Book added successfully");
            } else if (bookType.equalsIgnoreCase("C")) {
                book = new Commercial(bookType, title, author, ISBN, availabilityStatus);
                System.out.println("Commercial Book added successfully");
            } else if (bookType.equalsIgnoreCase("S")) {
                book = new Science(bookType, title, author, ISBN, availabilityStatus);
                System.out.println("Science Book added successfully");
            } else {
                book = new Book(bookType, title, author, ISBN, availabilityStatus);
                System.out.println("General Book added successfully");
            }
            bookCollection.add(book);
            for (Book bk : bookCollection) {
                System.out.print(bk.getISBN() + " " + bk.getTitle() + " " + bk.getAvailabilityStatus());
            }
        } else {
            System.out.println("Book already added. Try another!");
        }
    }

    public static void removeBook() {
        System.out.println("Enter ISBN:");
        String ISBN = reader.nextLine();

        // check if book is already in library
        boolean availabilityStatus = checkAvailability(ISBN);
        if (!availabilityStatus) {
            Iterator<Book> iterator = bookCollection.iterator();
            while (iterator.hasNext()) {
                Book book = iterator.next();
                if (book.getISBN().equals(ISBN)) {
                    iterator.remove();
                    System.out.println("Book removed successfully");
                    for (Book bk : bookCollection) {
                        System.out.print(bk.getISBN() + " " + bk.getTitle() + " " + bk.getAvailabilityStatus());
                    }
                }
            }
        } else {
            System.out.println("Book not found. Try another!");
        }

    }

    public static boolean checkAvailability(String ISBN) {
        // check if it's already in the collection
        boolean bookAvailability = true; // by default its in the collection
        if (!bookCollection.isEmpty()) {
            for (Book book : bookCollection) {
                if (book.getISBN().equals(ISBN)) {
                    bookAvailability = false;
                    break; // Exit the loop once the book is found
                }
            }
        }
        return bookAvailability;
    }

    // check borrowed
    public static boolean checkBorrowed(String ISBN) {
        boolean borrowedFeedback = false;
        for (Book book : bookCollection) {
            if (book.getISBN().equals(ISBN)) {
                if (book.getAvailabilityStatus()) { //available
                    borrowedFeedback = true; //can be borrowed
                } else {
                    borrowedFeedback = false;
                }
            }
        }
        return borrowedFeedback;
    }

    public static void checkBook() {
        System.out.println("Enter ISBN:");
        String ISBN = reader.nextLine();
        boolean checkLibrary = Library.checkAvailability(ISBN);
        boolean checkBorrow = Library.checkBorrowed(ISBN);

        //Book in library
        if(!checkLibrary){
            // borrowed
            for (Book bk : bookCollection) {
                System.out.print("ISBN: "+ bk.getISBN() +" .Title: "+ bk.getTitle() +" .Availability Status: "+ bk.getAvailabilityStatus());
            }
            if(!checkBorrow){
                //get the user who borrowed the book
                for (Book bk : bookCollection) {
                    for(User user: User.usersList){
                        if(user.userBorrowedBooks.contains(bk)){
                            System.out.println("Book is borrowed by" + user.getName());
                        }
                    }
                }
            }else{
                System.out.println("Book is available for borrowing");
            }
        }else{
            System.out.println("Book is not in Library. Add book");
        }

    }

}