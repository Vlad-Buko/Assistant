package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {

    private static final String SQLite = "jdbc:sqlite:/home/vladislav/JDBC/Assistant/identifier.sqlite";
    private static final String USERNAME = "SQLite04";
    private static final String PASSWORD = "SQLite04";

    private static Connection connection;

    static {
        try {
            Class.forName("org.sqlite.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(SQLite, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
