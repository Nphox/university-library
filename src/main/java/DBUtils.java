import java.sql.*;

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
