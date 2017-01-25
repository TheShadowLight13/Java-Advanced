import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int n = Integer.valueOf(console.nextLine());

        LinkedHashSet<String> names = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {

            String name = console.nextLine();
            names.add(name);
        }

        System.out.println(String.join("\n", names));
    }
}
