package db;

import java.sql.*;


public class Sqlite {
    public static Statement connect() {
        Statement i=null;
        try {
            Connection connection;
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            i = statement;
        } catch (SQLException e) {
        }
        return i;
    }

    public static void checkdb(Statement statement) {
        try {
            ResultSet rs = statement.executeQuery("SELECT * FROM tablename");
            while (rs.next()) {
                int i=0;
                String s = rs.getString(i);
                if (s.equals("calls") == true) {
                    break;
                } else {
                    createtable(statement);
                }
                i++;


            }
        } catch (SQLException e) {
        }
    }

    public static void createtable(Statement statement) {
        //В будущем при создании нескольких таблиц - создать класс с несколькими конструкторами
        try {
            String table = "calls (id INTEGER PRIMARY KEY, hz1 INTEGER , date1 INTEGER ,clock INTEGER ,time1 INTEGER ,hz2 INTEGER ,extnumber INTEGER , intnumber INTEGER , hz3 INTEGER )";
            statement.executeUpdate("CREATE TABLE " + table);
          //  statement.executeUpdate("CREATE TABLE calls (id INTEGER PRIMARY KEY, hz1 INTEGER , date1 INTEGER ,clock INTEGER ,time1 INTEGER ,hz2 INTEGER ,extnumber INTEGER , intnumber INTEGER , hz3 INTEGER)");
        } catch (SQLException e) {
        }
    }


    public static void fill(Statement statement,String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) throws SQLException {

        checkdb(statement);
        createtable(statement);
        try {
            statement.executeUpdate("INSERT INTO calls(hz1,date1,clock,time1,hz2,extnumber,intnumber,hz3) VALUES(" + s1 + "," + s2 + "," + s3 + "," + s4 + "," + s5 + "," + s6 + "," + s7 + "," + s8 + ")");
        } catch (SQLException e) {
        }


    }
    public  static void print(Statement statement) throws SQLException {
       ResultSet rs = statement.executeQuery("SELECT * FROM calls");
        while(rs.next())
        {

            System.out.print(rs.getInt("hz1"));
            System.out.print(rs.getInt("date1"));
            System.out.print(rs.getInt("clock"));
            System.out.print(rs.getInt("time1"));
            System.out.print(rs.getInt("hz2"));
            System.out.print(rs.getInt("extnumber"));
            System.out.print(rs.getInt("intnumber"));
            System.out.println(rs.getInt("hz3"));

        }

    }
    public static void exit(Connection connection) {
        {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {}
        }
    }
}