import java.util.Comparator;
import java.util.List;

public class ExcellentStudents {

    public static void getExcellentStudents(List<Student> students) {

        int targetGrade = 6;

        Comparator<Integer> descendingGrades = (g1,g2) -> g2.compareTo(g1);
        students.stream().filter(s -> s.getGrades().contains(targetGrade))
                .forEach(s -> {
                    System.out.printf("%s %s ", s.getFirstName(), s.getLastName());
                    s.getGrades().sort(descendingGrades);
                    s.getGrades().forEach(g -> System.out.printf("%d ", g));
                    System.out.println();
                });
    }
}

