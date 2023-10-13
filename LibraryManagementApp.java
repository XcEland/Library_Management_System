import java.util.Scanner;

public class LibraryManagementApp {
    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args){
        
        int choice;
        do {
            System.out.println("Library Management System");
            System.out.println("----------Menu-----------");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Check Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Add User");
            System.out.println("7. Check User");
            System.out.println("8. Remove User");
            System.out.println("9. Exit");
            System.out.println("------------------------");
            System.out.println("Enter your choice: ");
            choice = reader.nextInt();

            switch(choice){
                case 1:
                    Library.addBook();
                    break;
                
                case 2:
                    Library.removeBook();
                    break;
                
                case 3:
                    System.out.println("Enter ISBN:");
                    String ISBN = reader.nextLine();

                    Library.checkAvailability(ISBN);

                    break;
                
                case 4:
                    System.out.println("Enter ISBN:");
                    ISBN = reader.nextLine();
                    //User.borrowBook();
                    break;
                
                case 5:
                    System.out.println("Enter ISBN:");
                    ISBN = reader.nextLine();
                    //returnBook();
                    break;
                
                case 6:
                    User.addUser();
                    break;
                case 7:
                    System.out.println("Enter id:");
                    String id = reader.nextLine();
                    User.checkUser(id);
                    break;
                case 8:
                    User.removeUser();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.print("Invalid choice. Try again");
                    break;
            }
        } while (choice!= 9);
    }
}
