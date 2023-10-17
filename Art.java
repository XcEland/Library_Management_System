public class Art extends Book {
    public Art(String bookType, String title, String author, String ISBN, boolean avalabilityStatus) {
        super(bookType, title, author, ISBN, avalabilityStatus);
    }

    @Override
    public void toString(String title, String author, String ISBN, boolean availabilityStatus) {
        System.out.println("All Art Books in Library");
        System.out.println(" Title: " + title + ", Author: " + author + ", ISBN: " + ISBN
                + ", Can Borrow: " + avalabilityStatus);
    }

}
