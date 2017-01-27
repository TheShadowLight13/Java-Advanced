import java.io.*;
import java.util.List;

public class SerializeCustomObject {

    public static void main(String[] args) {

        String pathOut =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Lab\\input.txt";

        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3;
        cube.height = 12.4;
        cube.depth = 3.0;

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathOut))){

            oos.writeObject(cube);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathOut))){

            Cube deserializeCube = (Cube) ois.readObject();
            System.out.println(deserializeCube.color);
            System.out.println(deserializeCube.width);
            System.out.println(deserializeCube.height);
            System.out.println(deserializeCube.depth);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
