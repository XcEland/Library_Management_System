import java.util.ArrayList;
import java.util.Scanner;

abstract class User {
    private String name;
    private String id;
    protected ArrayList<Book> userBorrowedBooks;
    static ArrayList<User> usersList = new ArrayList<>();

    int count;
    static Scanner reader = new Scanner(System.in);

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.count = 0;
        this.userBorrowedBooks = new ArrayList<>();
    }

    public static String addUser() {
        System.out.println("Enter User Type(S/T):");
        String userType = reader.nextLine();

        System.out.println("Enter name:");
        String name = reader.nextLine();

        System.out.println("Enter id:");
        String id = reader.nextLine();
        String message = "";

        // check user it already exists
        boolean userAvailabilityStatus = checkUser(id);

        if (userAvailabilityStatus) {
            message += "User already added.";
        } else {
            User user;
            if (userType.equals("T")) {
                user = new Teacher(name, id);
                usersList.add(user);
                message += "Teacher added successfully.";
            } else if (userType.equals("S")) {
                user = new Student(name, id);
                usersList.add(user);
                message += "Student added successfully.";
            }
        }

        return message;
    }

    abstract String borrowBook();

    abstract String returnBook();

    // check user
    public static boolean checkUser(String id) {
        boolean userAvailability = false;
        for (User user : usersList) {
            if (user.getId().equals(id)) {
                userAvailability = true;
            } else {
                userAvailability = false;
            }
        }
        return userAvailability;
    }

    // check number of books
    public static int checkNumberOfBooksBorrowed(String id) {
        int feedBackCount = 0;
        for (User user : usersList) {
            if (user.getId().equals(id)) {
                feedBackCount = user.userBorrowedBooks.size();
            } else {
                System.out.println("User not found");
            }
        }
        return feedBackCount;
    }

    // remove user
    public static String removeUser() {
        System.out.println("Enter User id:");
        String userId = reader.nextLine();
        String message = "";

        boolean userAvailabilityStatus = checkUser(userId);
        if (userAvailabilityStatus) {
            for (User user : usersList) {
                if (user.getId().equals(userId)) {
                    usersList.remove(user);
                    message = "User has been removed successfully";
                } else {
                    message = "User not found";
                }
            }
        }
        return message;
    }

    // display user information
    public static void displayUser() {
        System.out.println("Enter User id:");
        String userId = reader.nextLine();

        boolean userAvailabilityStatus = checkUser(userId);
        if (userAvailabilityStatus) {
            for (User user : usersList) {
                if (user.getId().equals(userId)) {
                    System.out.println("User id: " + user.getId());
                    System.out.println("Username: " + user.getName());
                    System.out.println("Books Borrowed: ");

                    for (Book book : user.userBorrowedBooks) {
                        int counter = 1;
                        System.out.println(counter + ". " + " ISBN: " + book.getISBN() + " Title: " + book.getTitle()
                                + " Author: " + book.getAuthor() + " Status: " + book.getAvalabilityStatus());
                        counter++;
                    }

                }
            }
        }else{
                System.out.println("No user found");
            }
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}