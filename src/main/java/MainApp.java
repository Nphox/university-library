import java.sql.Connection;
import java.util.Set;


public class MainApp {
    public static void printBooks(Set<BookEntity> set){
        System.out.println("Size set: " + set.size());
        for (BookEntity book : set) {
            System.out.println(book.toString());
        }
    }

    public static void main(String[] args) {
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/libraryDB";
        String login = "root";
        String password = "root";
        String filePath = "/home/nphox/Документы/books.xls";

        Connection connection = DBUtils.getConnection(driverName, url, login, password);

        Set<BookEntity> books = null;

        try{
            books = ExcelParser.parse(filePath);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        DBUtils.insertIntoBooks(connection, books);
        DBUtils.closeConnection(connection);
    }
}
