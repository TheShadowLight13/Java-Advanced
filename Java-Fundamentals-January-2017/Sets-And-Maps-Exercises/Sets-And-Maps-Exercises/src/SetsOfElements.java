import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split("\\s+");
        int set1Len = Integer.valueOf(input[0]);
        int set2Len = Integer.valueOf(input[1]);

        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();

        for (int i = 0; i < set1Len; i++) {

            int number = Integer.valueOf(console.nextLine());
            set1.add(number);
        }

        for (int i = 0; i < set2Len; i++) {

            int number = Integer.valueOf(console.nextLine());
            set2.add(number);
        }

        set1.retainAll(set2);

        for (int number : set1) {

            System.out.format("%d ", number);
        }
    }
}
