import java.sql.*;
import java.util.Set;

public class DBUtils {
    public static void selectAllFromUsers(java.sql.Connection con){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = con.prepareStatement("SELECT * FROM users");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(
                        resultSet.getString("id") + "   " +
                                resultSet.getString("name") + " " +
                                resultSet.getString("age"));
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try{
                if(preparedStatement != null){
                    preparedStatement.close();
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void insertIntoBooks(java.sql.Connection con, Set<BookEntity> books){
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = con.prepareStatement("INSERT INTO Books (bookName, publicationYear, publisher) VALUES (?, ?, ?);");
            for (BookEntity book : books) {
                preparedStatement.setString(1, book.getBookName());
                preparedStatement.setString(2, book.getPublicationYear());
                preparedStatement.setString(3, book.getPublisher());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try{
                if(preparedStatement != null){
                    preparedStatement.close();
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection(String driverName, String url, String login, String password){
        Connection connection = null;

        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, login, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
