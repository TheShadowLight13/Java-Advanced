import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {

    public static void main(String[] args) {

        String[] srcFilesPaths =
                {"F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Create-Zip-Archive\\File1.txt",
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Create-Zip-Archive\\File2.txt",
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Create-Zip-Archive\\File3.txt"
                };
        String output =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Create-Zip-Archive\\files.zip";

        zipFiles(srcFilesPaths, output);
    }

    private static void zipFiles(String[] srcFilesPath, String output) {

        try (FileOutputStream fos = new FileOutputStream(output);
             ZipOutputStream zos = new ZipOutputStream(fos)){

            for (String filePath : srcFilesPath) {

                File inputFile = new File(filePath);
                ZipEntry zipEntry = new ZipEntry(inputFile.getName());
                zos.putNextEntry(zipEntry);

                FileInputStream fis = new FileInputStream(inputFile);
                byte[] buffer = new byte[1024];
                int bytesRead;

                while ((bytesRead = fis.read(buffer)) > 0) {

                    zos.write(buffer, 0, bytesRead);
                }

                zos.closeEntry();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
