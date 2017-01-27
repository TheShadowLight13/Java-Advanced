import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {

        String path =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\05. Java-Advanced-Files-and-Directories-Lab-Resources\\Files-and-Streams\\input.txt";

        try (FileInputStream fis = new FileInputStream(path)){

            int oneByte = fis.read();

            while (oneByte >= 0) {

                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
