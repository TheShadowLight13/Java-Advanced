import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {

    public static void main(String[] args) {

        String inputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\input.txt";
        String outputPath = "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(outputPath)) {

            while (scanner.hasNext()) {

                if (scanner.hasNextInt()) {

                    writer.println(scanner.nextInt());
                }

                scanner.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
