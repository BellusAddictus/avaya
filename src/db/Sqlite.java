package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Sqlite
{
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch  (ClassNotFoundException e)    {  }

        Connection connection = null;
        try {

            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
             }
        catch (SQLException e) {}

    }


    public static void fill()
    {


    }
}