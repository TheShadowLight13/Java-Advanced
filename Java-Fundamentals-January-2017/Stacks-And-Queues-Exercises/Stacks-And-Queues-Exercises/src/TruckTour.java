import java.util.ArrayDeque;
import java.util.Scanner;

public class TruckTour {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int stationsCount = Integer.valueOf(console.nextLine());

        ArrayDeque<Station> queue = new ArrayDeque<>();

        for (int i = 0; i < stationsCount; i++) {

            String[] token = console.nextLine().split(" ");
            int gasQuantity = Integer.valueOf(token[0]);
            int distanceToNext = Integer.valueOf(token[1]);

            Station station = new Station();
            station.gasQuantity = gasQuantity;
            station.distanceToNext = distanceToNext;

            queue.addLast(station);
        }

        Integer gasInTank = 0;
        boolean foundFirst = false;
        Integer index = 0;

        while (true) {

            Station currentStation = queue.removeFirst();
            gasInTank += currentStation.gasQuantity;
            queue.addLast(currentStation);

            Station firstStation = currentStation;
            Integer indexAddUp = 1;

            while (gasInTank >= currentStation.distanceToNext) {

                gasInTank -= currentStation.distanceToNext;
                currentStation = queue.removeFirst();
                queue.addLast(currentStation);
                gasInTank += currentStation.gasQuantity;
                indexAddUp++;

                if (currentStation == firstStation) {

                    foundFirst = true;
                    break;
                }
            }

            if (foundFirst) {
                break;
            }

            index += indexAddUp;
            gasInTank = 0;
        }

        System.out.println(index);
    }
}

class Station {

    int gasQuantity;
    int distanceToNext;
}
