import java.sql.*;

public class DBConnection {
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/churchvolunteer", "root", "root");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return connection;
    }
    public void dbDisconnect(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if (connection != null)
            connection.close();
        if (statement != null)
            statement.close();
        if (resultSet != null)
            resultSet.close();
    }
}
