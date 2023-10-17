public class Student extends User {
    static int maxCount = 5;

    public Student(String name, String id) {
        super(name, id);
    }

    public void borrowBook(String id) {
        // check user, book, count

        System.out.println("Enter ISBN:");
        String ISBN = reader.nextLine();

        boolean userAvailabilityStatus = User.checkUser(id);
        boolean bookAvailabilityStatus = Library.checkBorrowed(ISBN);
        int currentCount = User.checkNumberOfBooksBorrowed(id);

        // check count of books borrowed
        if (userAvailabilityStatus && bookAvailabilityStatus) {
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
                                System.out.println( "user not found");
                            }
                        }
                    } else {
                        System.out.println( "Book not found");
                    }
                }
            }
        }else if(!userAvailabilityStatus){
            System.out.println( "User not found");
        }else if(!bookAvailabilityStatus){
            System.out.println( "Book not found");
        }else{
            System.out.println( "Book and User not found");
        }

    }

    public void returnBook(String id) {
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
                            book.setAvalabilityStatus(true);
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
