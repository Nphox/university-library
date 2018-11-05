public class TableEntity {
    private String rowNum;
    private String author;
    private String bookName;
    private String type;
    private String publicationYear;
    private String realCountBooks;
    private String booksOnTheHands;

    public TableEntity(String rowNum, String author, String bookName, String type, String publicationYear, String realCountBooks, String booksOnTheHands) {
        this.rowNum = rowNum;
        this.author = author;
        this.bookName = bookName;
        this.type = type;
        this.publicationYear = publicationYear;
        this.realCountBooks = realCountBooks;
        this.booksOnTheHands = booksOnTheHands;
    }

    public String getRowNum() {
        return rowNum;
    }

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public String getType() {
        return type;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public String getRealCountBooks() {
        return realCountBooks;
    }

    public String getBooksOnTheHands() {
        return booksOnTheHands;
    }
    

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setRealCountBooks(String realCountBooks) {
        this.realCountBooks = realCountBooks;
    }

    public void setBooksOnTheHands(String booksOnTheHands) {
        this.booksOnTheHands = booksOnTheHands;
    }

    @Override
    public String toString() {
        return "TableEntity{" +
                "rowNum='" + rowNum + '\'' +
                ", author='" + author + '\'' +
                ", bookName='" + bookName + '\'' +
                ", type='" + type + '\'' +
                ", publicationYear='" + publicationYear + '\'' +
                ", realCountBooks='" + realCountBooks + '\'' +
                ", booksOnTheHands='" + booksOnTheHands + '\'' +
                '}';
    }
}
