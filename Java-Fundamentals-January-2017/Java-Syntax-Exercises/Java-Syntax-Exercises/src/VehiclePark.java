import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class VehiclePark {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> vehicles = new ArrayList<>();
        vehicles.addAll(Arrays.asList(scanner.nextLine().split(" ")));

        int vehiclesSold = 0;

        String input = scanner.nextLine();
        while (!input.equals("End of customers!"))
        {
            String[] commands = input.toLowerCase().split(" ");
            char vehicleType = commands[0].charAt(0);
            int seatsCount = Integer.valueOf(commands[2]);

            String vehicle = vehicleType + "" + seatsCount;
            if (vehicles.contains(vehicle))
            {
                int soldPrice = vehicleType*seatsCount;
                System.out.printf("Yes, sold for %d$\n", soldPrice);
                vehiclesSold++;
                vehicles.remove(vehicles.indexOf(vehicle));
            }
            else
            {
                System.out.println("No");
            }

            input = scanner.nextLine();
        }

        PrintLeftVehicles(vehicles, vehiclesSold);
    }

    private static void PrintLeftVehicles(ArrayList<String> vehicles, int vehiclesSold)
    {
        System.out.println("Vehicles left: " + String.join(", ", vehicles));
        System.out.printf("Vehicles sold: %d\n", vehiclesSold);
    }
}
