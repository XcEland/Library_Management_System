public class Book{
    private String title;
    private String author;
    private String ISBN;
    private boolean avalabilityStatus;

    public Book(String title, String author,String ISBN, boolean avalabilityStatus){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.avalabilityStatus = avalabilityStatus;
    }
    
    //setters and getters
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public void setAvalabilityStatus(boolean avalabilityStatus){
        this.avalabilityStatus = avalabilityStatus;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }

    public boolean getAvalabilityStatus(){
        return avalabilityStatus;
    }

    public String toString(String title, String author, String ISBN, boolean avalabilityStatus){
        return "Title: "  + title + ", Author: " + author + ", ISBN: " + ISBN + ", Status: "+avalabilityStatus;
    }

}