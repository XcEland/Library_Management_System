import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

abstract class User implements Borrowable {
    String name;
    String id;
    ArrayList<Book> userBorrowedBooks;
    static ArrayList<User> usersList = new ArrayList<>();

    int count;
    static Scanner reader = new Scanner(System.in);

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.count = 0;
        this.userBorrowedBooks = new ArrayList<>();
    }

    public static void addUser() {
        System.out.println("Enter User Type(S/T):");
        String userType = reader.nextLine();

        System.out.println("Enter name:");
        String name = reader.nextLine();

        System.out.println("Enter id:");
        String id = reader.nextLine();

        // check user it already exists
        boolean userAvailabilityStatus = checkUser(id);
        User user;
        if (!userAvailabilityStatus) {
            if (userType.equalsIgnoreCase("T")) {
                user = new Teacher(name, id);
                usersList.add(user);
                System.out.println("Teacher added successfully.");
            } else if (userType.equalsIgnoreCase("S")) {
                user = new Student(name, id);
                usersList.add(user);
                System.out.println("Student added successfully.");
            }
            for (User ur : usersList) {
                System.out.print(ur.getId() + " " + ur.getName());
            }
        } else {
            System.out.println("User already added. Try another!");
        }
    }

    public abstract void borrowBook(String userID);

    public abstract void returnBook(String userID);

    public static void userBorrowBook() {
        System.out.println("Enter user id");
        String userID = reader.nextLine();
        for (User user: usersList){
            if((user.getId().equals(userID))&&(user instanceof Teacher)){
                user.borrowBook(userID);
                break;
            }else if((user.getId().equals(userID))&&(user instanceof Student)){
                user.borrowBook(userID);
                break;
            }
        }
    }

    public static void userReturnBook(){
        System.out.println("Enter user id");
        String userID = reader.nextLine();
        for (User user: usersList){
            if((user.getId().equals(userID))&&(user instanceof Teacher)){
                user.returnBook(userID);
                break;
            }else if((user.getId().equals(userID))&&(user instanceof Student)){
                user.returnBook(userID);
                break;
            }
        }
    }

    public static boolean checkUser(String id) {
        boolean userAvailability = false; // default not in list
        for (User user : usersList) {
            if (user.getId().equals(id)) {
                userAvailability = true; // user is in list
                break;
            }
        }
        return userAvailability;
    }

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

    public static void removeUser() {
        System.out.println("Enter User id:");
        String userId = reader.nextLine();

        boolean userAvailabilityStatus = checkUser(userId);
        if (userAvailabilityStatus) {
            Iterator<User> iterator = usersList.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                if (user.getId().equals(userId)) {
                    iterator.remove();
                    System.out.println("User has been removed successfully");
                    for (User ur : usersList) {
                        System.out.print(ur.getId() + " " + ur.getName());
                    }
                }
            }
        } else {
            System.out.println("User not found. Try another!");
        }
    }

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
        } else {
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
