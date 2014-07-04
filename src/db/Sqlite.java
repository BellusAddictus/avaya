package db;

import java.sql.*;


public class Sqlite {
    public static Statement connect() {
        Statement i;
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
                String s = rs.getString("b");
                if (s.equals("calls") == true) {
                    break;
                } else {
                    createtable(statement);
                }


            }
        } catch (SQLException e) {
        }
    }

    public static void createtable(Statement statement) {
        //В будущем при создании нескольких таблиц - создать класс с несколькими конструкторами
        try {
            String table = "calls (id INTEGER PRIMARY KEY, hz1 INTEGER , date INTEGER ,clock INTEGER ,time INTEGER ,hz2 INTEGER ,extnumber INTEGER , intnumber INTEGER , hz3 INTEGER )";
            statement.executeUpdate("CREATE TABLE " + table);

        } catch (SQLException e) {
        }
    }


    public static void fill(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) throws SQLException {

        if (statement.isClosed() != true) {
            Statement statement = connect();
        }
        checkdb(statement);
        try {
            statement.executeUpdate("INSERT INTO calls(hz1,date,clock,time,hz2,extnumber,intnumber,hz3) VALUES(" + s1 + "," + s2 + "," + s3 + "," + s4 + "," + s5 + "," + s6 + "," + s7 + "," + s8 + ")");
        } catch (SQLException e) {
        }


    }
}