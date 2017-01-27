import java.io.*;
import java.util.ArrayDeque;

public class NestedFolders {

    public static void main(String[] args) {

        String inputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources";
        String outputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\output.txt";

        ArrayDeque<File> dirs = new ArrayDeque<>();

        File root = new File(inputPath);
        dirs.offer(root);

        int foldersCount = 0;

        try (PrintWriter output = new PrintWriter(new FileOutputStream(outputPath))){

            while (dirs.size() > 0) {

                File currFile = dirs.poll();

                if (currFile.exists()) {

                    for (File file : currFile.listFiles()) {

                        if (file.isDirectory()) {

                            output.println(file.getName());
                            dirs.add(file);
                            foldersCount++;
                        }
                    }
                }
            }

            output.printf("%d folders%n", foldersCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
