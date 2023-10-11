import java.util.ArrayList;
import java.util.Scanner;

abstract class User{
    private String name;
    private String id;
    static ArrayList<User> usersList = new ArrayList<>();
    int count;
    static Scanner reader = new Scanner(System.in);

    public User(String name, String id, int count){
        this.name = name;
        this.id = id;
        this.count = 0;
    }

    public static String addUser(){
        System.out.println("Enter User Type(S/T):");
        String userType = reader.nextLine();

        System.out.println("Enter name:");
        String name = reader.nextLine();

        System.out.println("Enter id:");
        String id = reader.nextLine();
        int count = 0;
        String message = "";

        // check user  it already exists
        boolean userAvailabilityStatus = checkUser(id);
        
        if(userAvailabilityStatus){
            message += "User already added.";
        }else{
            User user;
            if(userType.equals("T")){
                user = new Teacher(name, id, count);
                usersList.add(user);
                message += "Teacher added successfully.";
            }else if(userType.equals("S")){
                user = new Student(name, id, count);
                usersList.add(user);
                message += "Student added successfully.";
            }
        }
        
        return message;
    }

    abstract String borrowBook();
    abstract String returnBook();

    //check user
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


    //getters and setters
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