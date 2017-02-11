import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class WeakStudents {

    public static void getWeakStudents(List<Student> students) {

        Predicate<Student> targetMarks = s ->
                (s.getGrades().stream().filter(g -> g <= 3).count()) >= 2;
        Comparator<Student> studentsGradesAverageAscending = (s1,s2) ->
                Double.compare(
                        s1.getGrades().stream().mapToInt(Integer::intValue).average().getAsDouble(),
                        s2.getGrades().stream().mapToInt(Integer::intValue).average().getAsDouble());

        students.stream().filter(targetMarks).sorted(studentsGradesAverageAscending)
                .forEach(s -> {
                    System.out.printf("%s %s ", s.getFirstName(), s.getLastName());

                    s.getGrades().stream().sorted((g1,g2) -> g1.compareTo(g2))
                    .forEach(g -> System.out.printf("%d ", g));

                    System.out.println();
                });
    }
}
