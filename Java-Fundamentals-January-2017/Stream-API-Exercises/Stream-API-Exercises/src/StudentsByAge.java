import java.util.List;

public class StudentsByAge {

    public static void getStudentsByAge(List<Student> students) {

        int lowerBound = 18;
        int upperBound = 24;

        students.stream().filter(s -> s.getAge() >= lowerBound && s.getAge() <= upperBound)
                .forEach(s -> System.out.printf("%s %s %d%n",
                        s.getFirstName(), s.getLastName(), s.getAge()));
    }
}
