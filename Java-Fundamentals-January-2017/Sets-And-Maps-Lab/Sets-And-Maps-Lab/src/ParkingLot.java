import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashSet<String> carsNumbers = new HashSet<>();
        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] tokens = input.split(", ");
            String command = tokens[0];
            String carNumber = tokens[1];

            if (command.equals("IN")) {

                carsNumbers.add(carNumber);
            }else {

                carsNumbers.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        for (String carNumber : carsNumbers) {

            System.out.println(carNumber);
        }

        if (carsNumbers.isEmpty()) {

            System.out.println("Parking Lot is Empty");
        }
    }
}
