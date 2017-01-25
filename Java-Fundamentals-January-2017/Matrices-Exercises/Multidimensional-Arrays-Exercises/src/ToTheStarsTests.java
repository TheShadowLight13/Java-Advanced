import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ToTheStarsTests {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Star> stars = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            String[] starData = scanner.nextLine().split(" ");
            Star star = new Star();

            star.name = starData[0].toLowerCase();
            star.x = Double.valueOf(starData[1]);
            star.y = Double.valueOf(starData[2]);
            stars.add(star);
        }

        double[] starShipCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double startX = starShipCoordinates[0];
        double startY = starShipCoordinates[1];

        int distance = Integer.valueOf(scanner.nextLine());

        for (int i = 0; i <= distance; i++) {

            boolean isSpace = true;

            for (int j = 0; j < stars.size(); j++) {

                Star currStar = stars.get(j);

                if ((currStar.x - 1 <= startX && currStar.x + 1 >= startX) &&
                        (currStar.y - 1 <= startY && currStar.y + 1 >= startY)) {

                    isSpace = false;
                    System.out.println(currStar.name);
                    break;
                }
            }

            if (isSpace) {

                System.out.println("space");
            }

            startY++;
        }
    }
}

class Star {

    public String name;
    public double x;
    public double y;
}
