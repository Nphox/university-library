import java.sql.Connection;
import java.util.List;


public class MainApp {

    public static void printTableEntities(List<TableEntity> list){
        System.out.println("Size set: " + list.size());
        for (TableEntity entity : list) {
            System.out.println(entity.toString());
        }
    }

    public static void main(String[] args) {
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/libraryDB";
        String login = "root";
        String password = "root";
        String filePath = "/home/nphox/Документы/prepared-data.xls";

        Connection connection = DBUtils.getConnection(driverName, url, login, password);

        List<TableEntity> tableEntities = null;

        try{
            tableEntities = ExcelParser.parse(filePath);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        printTableEntities(tableEntities);
        DBUtils.closeConnection(connection);
    }
}
