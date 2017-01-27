import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeArrayList {

    public static void main(String[] args) {

        String output =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Serialize-Array-List\\list.ser";

        // Serialize object
        ArrayList<Double> numbers = new ArrayList<>();
        Collections.addAll(numbers, 13D, 12D, 7D, 7.7, 20.5);

        try (FileOutputStream fo = new FileOutputStream(output);
             ObjectOutputStream oos = new ObjectOutputStream(fo)){

            oos.writeObject(numbers);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize object
        try (FileInputStream fis = new FileInputStream(output);
             ObjectInputStream ois = new ObjectInputStream(fis)){

            List<Double> deserializeNumbers = (List<Double>) ois.readObject();
            System.out.println(deserializeNumbers);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
