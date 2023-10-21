import java.util.NoSuchElementException;

public class Student extends User {
    final static int maxCount = 5;

    public Student(String name, String id) {
        super(name, id);
    }

    public void borrowBook(String id) {
        try {
            System.out.println("Enter ISBN:");
            String ISBN = null;
            try {
                ISBN = reader.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("No input provided. Please try again.");
                return; // Exit the method after handling the exception
            }

            boolean userAvailabilityStatus = User.checkUser(id);
            boolean bookAvailabilityStatus = Library.checkBorrowed(ISBN);
            int currentCount = User.checkNumberOfBooksBorrowed(id);

            // Check count of books borrowed
            if (userAvailabilityStatus && bookAvailabilityStatus) {
                if (currentCount >= maxCount) {
                    System.out.println("Maximum number of books to borrow reached!");
                } else {
                    Book foundBook = null;
                    User foundUser = null;

                    for (Book book : Library.bookCollection) {
                        if (book.getISBN().equals(ISBN)) {
                            foundBook = book;
                            break;
                        }
                    }

                    for (User user : usersList) {
                        if (user.getId().equals(id)) {
                            foundUser = user;
                            break;
                        }
                    }

                    if (foundBook != null && foundUser != null) {
                        foundUser.userBorrowedBooks.add(foundBook);
                        foundBook.setAvailabilityStatus(false);
                        System.out.println("Book borrowed successfully");
                    } else {
                        System.out.println("Book or user not found");
                    }
                }
            } else if (!userAvailabilityStatus) {
                System.out.println("User not found");
            } else if (!bookAvailabilityStatus) {
                System.out.println("Book not found");
            } else {
                System.out.println("Book and User not found");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void returnBook(String id) {
        System.out.println("Enter ISBN:");
        String ISBN = null;
        try {
            ISBN = reader.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("No input provided. Please try again.");
            return; // Exit the method after handling the exception
        }

        boolean userAvailabilityStatus = User.checkUser(id);
        boolean bookAvailabilityStatus = Library.checkBorrowed(ISBN);

        // check count of books borrowed
        if (userAvailabilityStatus && bookAvailabilityStatus) {
            if (Library.bookCollection != null && usersList != null) {
                for (Book book : Library.bookCollection) {
                    if (book.getISBN().equals(ISBN)) {
                        for (User user : usersList) {
                            if (user.getId().equals(id)) {
                                user.userBorrowedBooks.remove(book);
                                book.setAvailabilityStatus(true);
                                System.out.println("Book returned successfully");
                            } else {
                                System.out.println("user not found");
                            }
                        }
                    } else {
                        System.out.println("Book not found");
                    }
                }
            } else {
                System.out.println("Library data not available");
            }
        }
    }
}
