import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String[] tokens = reader.readLine().split("\\s+");
            ArrayList<Long> numbers = new ArrayList<>();

            for (int i = 0; i < tokens.length; i++) {
                numbers.add(Long.valueOf(tokens[i]));
            }

            Consumer<ArrayList<Long>> print = createPrinter();

            String command = reader.readLine();
            while (!command.equals("end")) {

                if (command.equals("print")) {
                    print.accept(numbers);
                    System.out.println();
                    command = reader.readLine();
                    continue;
                }

                Function<Long, Long> mathOperation = createMathOperation(command);

                for (int i = 0; i < numbers.size(); i++) {

                    Long currNumber = numbers.get(i);
                    numbers.set(i, mathOperation.apply(currNumber));
                }

                command = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Consumer<ArrayList<Long>> createPrinter() {

        return numbers -> numbers.forEach(number -> System.out.printf("%d ", number));
    }

    private static Function<Long, Long> createMathOperation(String command) {

        switch (command) {
            case "add":
                return number -> number + 1L;
            case "multiply":
                return number -> number * 2L;
            case "subtract":
                return number -> number - 1L;
            default: return null;
        }
    }
}
