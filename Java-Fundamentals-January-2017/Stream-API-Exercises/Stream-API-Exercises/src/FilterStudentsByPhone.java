import java.util.List;

public class FilterStudentsByPhone {

    public static void getStudentsByPhone(List<Student> students) {

        String firstPrefix = "02";
        String secondPrefix = "+3592";
        students.stream().filter(
                s -> s.getPhone().startsWith(firstPrefix) || s.getPhone().startsWith(secondPrefix))
                .forEach(s -> System.out.printf("%s %s %s%n",
                        s.getFirstName(), s.getLastName(), s.getPhone()));
    }
}
