import java.sql.Connection;

public class MainApp {
    public static void main(String[] args) {
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/libraryDB";
        String login = "root";
        String password = "root";

        Connection connection = DBUtils.getConnection(driverName, url, login, password);
        DBUtils.closeConnection(connection);
    }
}
