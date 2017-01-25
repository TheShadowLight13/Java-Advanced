import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.valueOf(console.nextLine());
        TreeSet<String> chemicalElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {

            List<String> compoundElements = Arrays.asList(console.nextLine().split(" "));
            chemicalElements.addAll(compoundElements);
        }

        System.out.println(String.join(" ", chemicalElements));
    }
}
