import java.io.*;

public class WriteEveryThirdLine {

    public static void main(String[] args) {

        String inputPath =
               "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\input.txt";
        String outputPath = "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\output.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){

            String line = reader.readLine();
            int counter = 1;

            while (line != null) {

                if (counter % 3 == 0) {

                    writer.println(line);
                }

                counter++;
                line = reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
