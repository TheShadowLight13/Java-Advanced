import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PoisonousPlants {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.valueOf(console.nextLine());
        List<Integer> plants = Arrays.stream(console.nextLine().split(" "))
                .map(s -> Integer.valueOf(s))
                .collect(Collectors.toList());

        int[] days = new int[n];
        Stack<Integer> proximityStack = new Stack<>();
        proximityStack.add(0);

        for (int i = 1; i < plants.size(); i++) {

            int maxDays = 0;
            while (proximityStack.size() > 0 && plants.get(proximityStack.peek()) >= plants.get(i)) {

                maxDays = Math.max(maxDays, days[proximityStack.pop()]);
            }

            if (proximityStack.size() > 0) {

                days[i] = maxDays + 1;
            }

            proximityStack.push(i);
        }

        List<Integer> daysList = IntStream.of(days).boxed().collect(Collectors.toList());
        System.out.println(Collections.max(daysList));
    }
}
