import java.io.File;

public class ListFiles {

    public static void main(String[] args) {

        String inputPath = "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams";

        File file = new File(inputPath);

        if (file.exists()) {

            if (file.isDirectory()) {

                File[] listOfFiles = file.listFiles();

                for (File currFile : listOfFiles) {

                    if (!currFile.isDirectory()) {

                        String fileName = currFile.getName();
                        long fileSize = currFile.length();

                        System.out.printf("%s: %d%n", fileName, fileSize);
                    }
                }
            }
        }
    }
}
