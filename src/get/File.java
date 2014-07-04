package get;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by gaa on 04.07.14.
 */
public class File {
    public File(String file) throws IOException {
        ReadFile(file);
    }

    public static void ReadFile(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                line = br.readLine();
                String all = sb.toString();

                if (line.length() > 40) {
                    line = ClearString(line);
                    System.out.println(line);
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
