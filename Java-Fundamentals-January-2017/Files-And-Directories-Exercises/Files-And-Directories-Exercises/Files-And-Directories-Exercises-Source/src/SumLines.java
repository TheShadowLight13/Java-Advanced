import java.io.*;

public class SumLines {

    public static void main(String[] args) {

        String inputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Sum-Lines\\Input.txt";
        String outputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Sum-Lines\\Output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){

            String line = reader.readLine();

            while (line != null) {

                int sum = 0;
                for (int i = 0; i < line.length(); i++) {

                    sum += line.charAt(i);
                }

                writer.println(sum);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
