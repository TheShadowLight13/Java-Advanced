import java.util.List;

public class FilterStudentsByEmailDomain {

    public static void getStudentsByEmailDomain(List<Student> students) {

        String targetEmailDomain = "@gmail.com";
        students.stream().filter(s -> s.getEmail().endsWith(targetEmailDomain))
                .forEach(s -> System.out.printf("%s %s %s%n",
                        s.getFirstName(), s.getLastName(), s.getEmail()));
    }
}
