import java.util.Comparator;
import java.util.List;

public class SortStudents {

    public static void getSortedStudents(List<Student> students) {

        Comparator<Student> lastNameAscending = (s1,s2) ->
                s1.getLastName().compareTo(s2.getLastName());

        Comparator<Student> studentComparator =
                lastNameAscending.thenComparing(
                (s1, s2) ->
                s2.getFirstName().compareTo(s1.getFirstName()));

        students.stream().sorted(studentComparator)
                .forEach(s -> System.out.printf("%s %s%n", s.getFirstName(), s.getLastName()));
    }
}
