public class Student extends User {
    protected int maxCount = 5;

    public Student(String name, String id, int count){
        super(name, id, count);
    }

    public String borrowBook(){
        // check user, book, count
        System.out.println("Enter id:");
        String id = reader.nextLine();

        System.out.println("Enter ISBN:");
        String ISBN = reader.nextLine();

        boolean userAvailabilityStatus = super.checkUser(id);
        boolean bookAvailabilityStatus = Library.checkAvailability(ISBN);
        

        //check count of books borrowed
        if(userAvailabilityStatus ){
            for(User user: usersList){

            }
        }
        

        return null;
    }

    public String returnBook(){
        
        return null;
    }
}
