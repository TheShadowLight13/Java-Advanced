import java.util.Arrays;
import java.util.Scanner;

public class TriangleArea {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double[] firstPointCoordinates = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double firstPointX = firstPointCoordinates[0];
        double firstPointY = firstPointCoordinates[1];

        double[] secondPointCoordinates = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double secondPointX = secondPointCoordinates[0];
        double secondPointY = secondPointCoordinates[1];

        double[] thirdPointCoordinates = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double thirdPointX = thirdPointCoordinates[0];
        double thirdPointY = thirdPointCoordinates[1];

        double area = Math.abs((firstPointX * (secondPointY - thirdPointY) +
                secondPointX * (thirdPointY - firstPointY) +
                thirdPointX * (firstPointY - secondPointY)) / 2);

        System.out.println((int) area);
    }
}
