public class Teacher extends User {
    static int maxCount = 10;

    public Teacher(String name, String id){
        super(name, id);
    }

    public static void borrowBook() {
        // check user, book, count
        System.out.println("Enter id:");
        String id = reader.nextLine();

        System.out.println("Enter ISBN:");
        String ISBN = reader.nextLine();

        boolean userAvailabilityStatus = User.checkUser(id);
        boolean bookAvailabilityStatus = Library.checkBorrowed(ISBN);
        int currentCount = User.checkNumberOfBooksBorrowed(id);

        // check count of books borrowed
      
        if (userAvailabilityStatus && !bookAvailabilityStatus) {
            if (currentCount >= maxCount) {
                System.out.println("Maximum number of books to borrow reached!");
            } else {
                for (Book book : Library.bookCollection) {
                    if (book.getISBN().equals(ISBN)) {
                        for (User user : usersList) {
                            if (user.getId().equals(id)) {
                                user.userBorrowedBooks.add(book);
                                bookAvailabilityStatus = false;
                                book.setAvalabilityStatus(bookAvailabilityStatus);
                                System.out.println("Book borrowed successfully");
                            } else {
                                System.out.println("user not found");
                            }
                        }
                    } else {
                        System.out.println("Book not found");
                    }
                }
            }
        }

       
    }

    public static void returnBook() {
        // check user, book, count
        System.out.println("Enter id:");
        String id = reader.nextLine();

        System.out.println("Enter ISBN:");
        String ISBN = reader.nextLine();

        boolean userAvailabilityStatus = User.checkUser(id);
        boolean bookAvailabilityStatus = Library.checkBorrowed(ISBN);

        // check count of books borrowed
        if (userAvailabilityStatus && bookAvailabilityStatus) {
            for (Book book : Library.bookCollection) {
                if (book.getISBN().equals(ISBN)) {
                    for (User user : usersList) {
                        if (user.getId().equals(id)) {
                            user.userBorrowedBooks.remove(book);
                            bookAvailabilityStatus = true;
                            book.setAvalabilityStatus(bookAvailabilityStatus);
                            System.out.println("Book returned successfully");
                        } else {
                            System.out.println("user not found");
                        }
                    }
                } else {
                    System.out.println("Book not found");
                }
            }
        }

    }
}

