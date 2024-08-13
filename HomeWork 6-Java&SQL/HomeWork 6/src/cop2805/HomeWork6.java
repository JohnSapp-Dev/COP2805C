package cop2805;
import java.sql.*;

public class HomeWork6 {

    public static void main(String[] args) {

        Connection connection;
        try {
            ResultSet results = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
                        "root","cop2805");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees;");

                while(resultSet.next()){
                    int IDNumber = resultSet.getInt("employeeId");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");

                    System.out.println(IDNumber +": "+ lastName+", "+ firstName);
                }

                connection.close();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}