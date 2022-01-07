import java.sql.*;

public class Main {

  private static final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
  private static final String DB_SCHEMA = "DB_SCHEMA";
  private static final String DB_PASSWORD = "DB_PASSWORD";

  public static void main(String[] args) {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //String query = "select username from users where location = " + args[0] + ";";
    String query = "select username from users where location = ?";

    try {

      connection = DriverManager.getConnection(JDBC_URL, DB_SCHEMA, DB_PASSWORD);
      preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, args[0]);
      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        // ...
      }

    } catch (SQLException e) {
      System.out.println("An error occured while executing the query. Reason: " + e.getMessage());
    }
  }

}
