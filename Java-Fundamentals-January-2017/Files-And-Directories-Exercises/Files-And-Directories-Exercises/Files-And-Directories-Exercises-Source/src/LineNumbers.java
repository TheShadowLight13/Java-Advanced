import java.io.*;

public class LineNumbers {

    public static void main(String[] args) {

        String inputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Line-Numbers\\Input.txt";
        String outputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Line-Numbers\\Output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){

            int lineCounter = 1;
            String line = reader.readLine();

            while (line != null) {

                line = (lineCounter + ". " + line);
                writer.println(line);

                line = reader.readLine();
                lineCounter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
