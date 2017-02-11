import java.util.List;

public class StudentsByGroup {

    public static void getStudentsByGroup(List<Student> students) {

        Integer targetGroup = 2;
        students.stream().filter(s -> s.getGroup().equals(targetGroup))
                .sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
                .forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
    }
}
