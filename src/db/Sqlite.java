package db;
import java.sql.*;


public class Sqlite
{
    public static void connect(Connection connection)
    {
        try {

            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

        }
        catch (SQLException e) {}

    }

    public static void checkbd(Statement statement)
    {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM tablename");
            while (rs.next())
            {


                String s = rs.getString("b");


            }
        }
        catch (SQLException e){}
    }



    public static void fill(Statement statement, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8)
    {
        try {
        statement.executeUpdate("")
        }
        catch (SQLException e){}



    }
}