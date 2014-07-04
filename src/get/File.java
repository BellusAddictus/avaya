/*
 * A.Ganin 2014.
 */


package get;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
/*                sb.append(line);
                sb.append(System.lineSeparator());
                String all = sb.toString();*/
                line = br.readLine();
                if (line.length() > 40) {
                    line = ClearString(line);
                    String word[] = line.split(";");
                    if (word.length < 8) {
                        System.out.println("False");
                    } else {
                        System.out.println("OK");
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
