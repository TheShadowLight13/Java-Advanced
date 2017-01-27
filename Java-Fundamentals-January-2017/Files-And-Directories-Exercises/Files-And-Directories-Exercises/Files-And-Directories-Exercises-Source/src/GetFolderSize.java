import java.io.*;
import java.util.ArrayDeque;

public class GetFolderSize {

    public static void main(String[] args) {

        String folderPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\Files-and-Streams";

        File root = new File(folderPath);
        ArrayDeque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        long totalFolderSize = 0;

        while (dirs.size() > 0) {

            File currFile = dirs.poll();

            if (currFile.exists()) {

                    for (File file : currFile.listFiles()) {

                        if (file.isDirectory()) {

                            dirs.offer(file);
                        }else {
                            totalFolderSize = totalFolderSize + file.length();
                        }
                    }
                }
            }

        System.out.printf("Folder size: %d", totalFolderSize);
    }
}
