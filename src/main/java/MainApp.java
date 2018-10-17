import java.sql.Connection;

public class MainApp {
    public static void main(String[] args) {
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testDB";
        String login = "root";
        String password = "root";

        Connection connection = DBUtils.getConnection(driverName, url, login, password);
        DBUtils.selectAllFromUsers(connection);
        DBUtils.closeConnection(connection);
    }
}