import java.util.List;

public class StudentsByFirstLastName {

    public static void getStudentsByFirstLastName(List<Student> students) {

        students.stream().filter(s -> s.getFirstName().compareTo(s.getLastName()) < 0)
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
    }
}
