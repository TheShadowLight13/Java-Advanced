import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Path studentsDataPath = Paths.get("StudentData.txt");
        List<String> data = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        try {

            data = Files.readAllLines(studentsDataPath);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < data.size(); i++) {

            String[] tokens = data.get(i).split("\\s+");
            String facultNum = tokens[0];
            String firstName = tokens[1];
            String lastName = tokens[2];
            String email = tokens[3];
            Integer age = Integer.valueOf(tokens[4]);
            Integer group = Integer.valueOf(tokens[5]);
            String phone = tokens[10];

            Student student = new Student(
                    facultNum, firstName, lastName, email, age, group, phone);

            for (int gradeIndex = 6; gradeIndex < 10; gradeIndex++) {

                Integer grade = Integer.valueOf(tokens[gradeIndex]);
                student.getGrades().add(grade);
            }

            students.add(student);
        }

        // Get Students by group 2
        //StudentsByGroup.getStudentsByGroup(students);

        // Get Students if their firstName is before lastName lexicographically
        //StudentsByFirstLastName.getStudentsByFirstLastName(students);

        // Get Students by age
        //StudentsByAge.getStudentsByAge(students);

        // Get Students by lastName then by firstName
        //SortStudents.getSortedStudents(students);

        // Get students with target email domain
        //FilterStudentsByEmailDomain.getStudentsByEmailDomain(students);

        // Get students by target phone
        //FilterStudentsByPhone.getStudentsByPhone(students);

        // Get excellent students
        //ExcellentStudents.getExcellentStudents(students);

        // Get weak students
        //WeakStudents.getWeakStudents(students);

        // Get students by enrollment year
        //StudentsByEnrollmentYear.getStudentsByEnrollmentYear(students);


    }
}
