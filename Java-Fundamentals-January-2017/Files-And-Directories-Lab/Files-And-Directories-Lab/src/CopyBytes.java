import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyBytes {

    public static void main(String[] args) {

        String inputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\input.txt";
        String outputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\output.txt";

        try (FileInputStream reader = new FileInputStream(inputPath);
             FileOutputStream writer = new FileOutputStream(outputPath)){

            int oneByte = reader.read();

            while (oneByte >= 0) {

                if (oneByte == ' ' || oneByte == '\n') {

                    writer.write(oneByte);
                }else {

                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {

                        writer.write(digits.charAt(i));
                    }
                }

                oneByte = reader.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
