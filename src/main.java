import get.File;
import db.Sqlite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by gaa on 04.07.14.
 */
public class main {
    public static void main(String[] args) throws IOException {
        String file = "/tmp/Avaya.log";
        new File(file);
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch  (ClassNotFoundException e)    {  }

        Connection connection = null;
        Statement statement = Sqlite.connect(connection);



    }
}
