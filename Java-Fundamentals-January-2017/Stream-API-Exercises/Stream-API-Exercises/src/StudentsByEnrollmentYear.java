import java.util.*;
import java.util.stream.Collectors;

public class StudentsByEnrollmentYear {

    public static void getStudentsByEnrollmentYear(List<Student> students) {

        TreeMap<Integer, List<Student>> studentsByEnrollmentYear = new TreeMap<>();

        for (Student student : students) {

            String facultNumber = student.getFacultyNumber();
            Integer enrollmentYear = Integer.valueOf("20" + facultNumber.substring(facultNumber.length() - 2));

            studentsByEnrollmentYear.putIfAbsent(enrollmentYear, new ArrayList<>());
            studentsByEnrollmentYear.get(enrollmentYear).add(student);
        }

        Comparator<Student> firstNameAscending = (s1,s2) ->
                s1.getFirstName().compareTo(s2.getFirstName());
        Comparator<Student> studentNameComparator = firstNameAscending.
                thenComparing((s1,s2) -> s1.getLastName().compareTo(s2.getLastName()));

        for (Integer enrollmentYear : studentsByEnrollmentYear.keySet()) {

            System.out.printf("%d: %n", enrollmentYear);
            List<Student> studentsInYear = studentsByEnrollmentYear.get(enrollmentYear);

            studentsInYear.stream().sorted(studentNameComparator)
                    .forEach(s ->
                            System.out.printf("-- %s %s%n", s.getFirstName(), s.getLastName()));
        }
    }
}
