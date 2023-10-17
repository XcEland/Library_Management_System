public class Science extends Book {

    public Science(String bookType, String title, String author,String ISBN, boolean avalabilityStatus){
        super(bookType, title, author, ISBN, avalabilityStatus);
    }

    @Override
    public void display(String title, String author, String ISBN, boolean availabilityStatus) {
        System.out.println("All Science Books in Library");
        System.out.println(" Title: " + title + ", Author: " + author + ", ISBN: " + ISBN
                + ", Can Borrow: " + avalabilityStatus);
    }
}
