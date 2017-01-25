import java.util.*;

public class AcademyGraduation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.valueOf(scanner.nextLine());
        TreeMap<String, List<Double>> scoresByName = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            if (!scoresByName.containsKey(name)) {

                scoresByName.put(name, new ArrayList<>());
            }

            for (int j = 0; j < scores.length; j++) {

                scoresByName.get(name).add(scores[j]);
            }
        }

        for (String name : scoresByName.keySet()) {

            List<Double> scores = scoresByName.get(name);
            double averageScore = averageScores(scores);

            System.out.printf("%s is graduated with %s%n", name, averageScore);
        }
    }

    private static double averageScores(List<Double> scores) {

        double averageScore = 0;

        for (int i = 0; i < scores.size(); i++) {

            averageScore += scores.get(i);
        }

        averageScore = averageScore / scores.size();
        return averageScore;
    }
}
