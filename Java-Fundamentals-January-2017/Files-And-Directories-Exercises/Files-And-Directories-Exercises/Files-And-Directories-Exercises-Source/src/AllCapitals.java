import java.io.*;

public class AllCapitals {

    public static void main(String[] args) {

        String inputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\ALL-CAPITALS\\Input.txt";
        String outputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\ALL-CAPITALS\\Output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){

            String line = reader.readLine();

            while (line != null) {

                writer.println(line.toUpperCase());
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
