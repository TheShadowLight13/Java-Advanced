import java.io.*;

public class SumBytes {

    public static void main(String[] args) {

        String inputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Sum-Bytes\\Input.txt";
        String outputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Sum-Bytes\\Output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){

            String line = reader.readLine();
            long sum = 0;

            while (line != null) {

                for (int i = 0; i < line.length(); i++) {

                    sum += line.charAt(i);
                }

                line = reader.readLine();
            }

            writer.print(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
