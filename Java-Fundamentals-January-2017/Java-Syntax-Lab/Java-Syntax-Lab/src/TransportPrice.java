import java.util.Scanner;

public class TransportPrice {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int distance = Integer.valueOf(scanner.nextLine());
        String timeOfDay = scanner.nextLine();

        double pricePerKm = 0;
        double totalPrice = 0;

        if (distance < 20) {

            totalPrice += 0.70;
            pricePerKm = timeOfDay.equals("day") ? 0.79 : 0.90;
        }else if (distance >= 20 && distance < 100) {

            pricePerKm = 0.09;
        }else {

            pricePerKm = 0.06;
        }

        totalPrice += (distance * pricePerKm);
        System.out.printf("%.2f", totalPrice);
    }
}
