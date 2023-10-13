public class Teacher extends User {
    protected int maxCount = 10;

    public Teacher(String name, String id){
        super(name, id);
    }

    public String borrowBook() {
        // check user, book, count
        System.out.println("Enter id:");
        String id = reader.nextLine();

        System.out.println("Enter ISBN:");
        String ISBN = reader.nextLine();

        boolean userAvailabilityStatus = super.checkUser(id);
        boolean bookAvailabilityStatus = Library.checkBorrowed(ISBN);
        int currentCount = super.checkNumberOfBooksBorrowed(id);

        // check count of books borrowed
        String message = "";
        if (userAvailabilityStatus && !bookAvailabilityStatus) {
            if (currentCount >= maxCount) {
                message = "Maximum number of books to borrow reached!";
            } else {
                for (Book book : Library.bookCollection) {
                    if (book.getISBN().equals(ISBN)) {
                        for (User user : usersList) {
                            if (user.getId().equals(id)) {
                                user.userBorrowedBooks.add(book);
                                bookAvailabilityStatus = false;
                                book.setAvalabilityStatus(bookAvailabilityStatus);
                                message = "Book borrowed successfully";
                            } else {
                                message = "user not found";
                            }
                        }
                    } else {
                        message = "Book not found";
                    }
                }
            }
        }

        return message;
    }

    public String returnBook() {
        // check user, book, count
        System.out.println("Enter id:");
        String id = reader.nextLine();

        System.out.println("Enter ISBN:");
        String ISBN = reader.nextLine();

        boolean userAvailabilityStatus = super.checkUser(id);
        boolean bookAvailabilityStatus = Library.checkBorrowed(ISBN);

        // check count of books borrowed
        String message = "";
        if (userAvailabilityStatus && bookAvailabilityStatus) {
            for (Book book : Library.bookCollection) {
                if (book.getISBN().equals(ISBN)) {
                    for (User user : usersList) {
                        if (user.getId().equals(id)) {
                            user.userBorrowedBooks.remove(book);
                            bookAvailabilityStatus = true;
                            book.setAvalabilityStatus(bookAvailabilityStatus);
                            message = "Book returned successfully";
                        } else {
                            message = "user not found";
                        }
                    }
                } else {
                    message = "Book not found";
                }
            }
        }

        return message;
    }
}
