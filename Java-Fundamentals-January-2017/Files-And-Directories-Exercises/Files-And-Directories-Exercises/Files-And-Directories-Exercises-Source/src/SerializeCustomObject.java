import java.io.*;

public class SerializeCustomObject {

    public static void main(String[] args) {

        String output =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Serialize-Custom-Object\\course.ser";

        // Serialize object
        Course course = new Course();
        course.name = "Java Advanced";
        course.numberOfStudents = 100;

        try (FileOutputStream fos = new FileOutputStream(output);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(course);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize object
        try (FileInputStream fis = new FileInputStream(output);
             ObjectInputStream ois = new ObjectInputStream(fis)){

            Course deserializeCourse = (Course) ois.readObject();
            System.out.println(deserializeCourse.name);
            System.out.println(deserializeCourse.numberOfStudents);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
