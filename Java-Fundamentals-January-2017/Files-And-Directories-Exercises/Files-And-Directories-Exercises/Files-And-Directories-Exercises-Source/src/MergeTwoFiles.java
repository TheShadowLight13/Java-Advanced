import java.io.*;

public class MergeTwoFiles {

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {

        String firstFilePath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\MergeTwoFiles\\FirstFile.txt";
        String secondFilePath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\MergeTwoFiles\\SecondFile.txt";

        StringBuilder output = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(firstFilePath))){

            String line = reader.readLine();

            while (line != null) {

                output.append(line);
                output.append("\n");
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(secondFilePath))){

            String line = reader.readLine();

            while (line != null) {

                output.append(line);
                output.append("\n");
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(output);
    }
}
