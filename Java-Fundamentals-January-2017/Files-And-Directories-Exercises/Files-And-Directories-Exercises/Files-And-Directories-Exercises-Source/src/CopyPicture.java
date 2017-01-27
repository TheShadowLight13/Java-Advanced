import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyPicture {

    public static void main(String[] args) {

        String sourcePath = "F:\\Pictures\\Saved Pictures\\lightning1.jpg";
        String targetPath = "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Copy-Picture";

        String newFileName = "picture-copy.jpg";

        Path sourceDir = Paths.get(sourcePath);
        Path targetDir = Paths.get(targetPath);

        try {
            Files.createDirectories(targetDir);
            Path target = targetDir.resolve(newFileName);
            System.out.println("Copying into " + target);
            Files.copy(sourceDir, target, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
