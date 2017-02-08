import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Predicate;

public class Inferno {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            ArrayList<Integer> numbers = new ArrayList<>();
            String[] tokens = reader.readLine().split(" ");

            for (int i = 0; i < tokens.length; i++) {
                numbers.add(Integer.valueOf(tokens[i]));
            }

            HashSet<String> filtersData = new HashSet<>();

            String input = reader.readLine();

            while (!input.equals("Forge")) {

                String[] commands = input.split(";");
                String commandType = commands[0];
                String filterType = commands[1];
                int filterParam = Integer.valueOf(commands[2]);

                String filterTypeParam = filterType + ";" + filterParam;

                if (commandType.equals("Exclude")) {
                    filtersData.add(filterTypeParam);
                }else {
                    filtersData.remove(filterTypeParam);
                }

                input = reader.readLine();
            }

            ArrayList<Integer> numbersToExclude = new ArrayList<>();

            for (String filterData : filtersData) {

                tokens = filterData.split(";");
                String filterType = tokens[0];
                int filterParam = Integer.valueOf(tokens[1]);

                for (int i = 0; i < numbers.size(); i++) {

                    int leftNum = 0;
                    int rightNum = 0;
                    int currNum = 0;

                    currNum = numbers.get(i);

                    if (i != 0) {

                        leftNum = numbers.get(i - 1);
                    }

                    if (i != numbers.size() - 1) {
                        rightNum = numbers.get(i + 1);
                    }

                    Predicate<Integer> tester = createTester(filterType, filterParam, leftNum, rightNum);
                    if (tester.test(currNum)) {

                        numbersToExclude.add(currNum);
                    }
                }
            }

            numbers.removeAll(numbersToExclude);
            numbers.forEach(n -> System.out.printf("%d ", n));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<Integer> createTester(String filterType, int filterParam,
                                                   int leftNum, int rightNum) {
        switch (filterType) {
            case "Sum Left":
                return number -> filterParam == leftNum + number;
            case "Sum Right":
                return number -> filterParam == rightNum + number;
            case "Sum Left Right":
                return number -> filterParam == leftNum + number + rightNum;
            default: return null;
        }
    }
}
