import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinersTask {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        LinkedHashMap<String, Integer> quantityByResource = new LinkedHashMap<>();

        while (!input.equals("stop")) {

            String resource = input;
            Integer quantity = Integer.valueOf(sc.nextLine());

            if (!quantityByResource.containsKey(resource)) {

                quantityByResource.put(resource, 0);
            }

            int newQuantity = quantityByResource.get(resource) + quantity;
            quantityByResource.put(resource, newQuantity);

            input = sc.nextLine();
        }

        for (Map.Entry<String,Integer> entry : quantityByResource.entrySet()) {

            String resource = entry.getKey();
            Integer quantity = entry.getValue();

            System.out.printf("%s -> %s\n", resource, quantity);
        }
    }
}
