/*
 * A.Ganin 2014.
 */


package get;

import db.Sqlite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;


public class File {
    public File(String file, Statement statement) throws IOException {
        ReadFile(file, statement);
    }

    public static void ReadFile(String file, Statement statement) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
//            for (int i = 0; i < 10; i++) {
                sb.append(line); // А этим волшебным образом мы можем получить сразу весь файл.
                sb.append(System.lineSeparator());
                String all = sb.toString();
                line = br.readLine();
                if (line.length() > 40) {
                    line = ClearString(line);
                    String word[] = line.split(";");
                    if (word.length != 8) {
                        System.out.println("False");
                    } else {
                        try {
                            Sqlite.fill(statement, word[0], word[1], word[2], word[3], word[4], word[5], word[6], word[7]);
                            System.out.print(word[0] + " ");
                            System.out.print(word[1] + " ");
                            System.out.print(word[2] + " ");
                            System.out.print(word[3] + " ");
                            System.out.print(word[4] + " ");
                            System.out.print(word[5] + " ");
                            System.out.print(word[6] + " ");
                            System.out.println(word[7] + " ");
//                            System.out.println("OK");
                        } catch (SQLException e) {
                        }

                    }
                }
            }

        } finally {
            br.close();
        }

    }

    public static String ClearString(String line) {
        String clearLine;
        clearLine = line.replaceAll(" +", ";");
        return clearLine;
    }
}
