public class BookEntity {
    private int id;
    private String bookName;
    private String publicationYear;
    private String publisher;

    public BookEntity(int id, String bookName, String publicationYear, String publisher) {
        this.id = id;
        this.bookName = bookName;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
    }

    public BookEntity(String bookName, String publicationYear, String publisher) {
        this.bookName = bookName;
        this.publicationYear = publicationYear;
        this.publisher = publisher;
    }

    public String toString(){
        return this.bookName + " " + this.publicationYear + " " + this.publisher;
    }

    public int getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }
}
