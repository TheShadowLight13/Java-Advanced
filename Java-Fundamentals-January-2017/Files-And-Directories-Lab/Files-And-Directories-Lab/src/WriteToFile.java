import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;

public class WriteToFile {

    public static void main(String[] args) {

        String inputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\input.txt";
        String outputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\output.txt";

        HashSet<Character> punctions = new HashSet<>();
        Collections.addAll(punctions, ',', '.', '!', '?');

        try (FileInputStream reader = new FileInputStream(inputPath);
             FileOutputStream writer = new FileOutputStream(outputPath)){

           int oneByte = reader.read();

           while (oneByte >= 0) {

               if (!punctions.contains((char)oneByte)) {

                   writer.write(oneByte);
               }

               oneByte = reader.read();
           }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
