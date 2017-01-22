import java.util.Scanner;

public class HitTheTarget {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int targetNum = scanner.nextInt();

        for (int i = 1; i <= 20 ; i++) {

            for (int j = 1; j <= 20 ; j++) {

                if (i + j == targetNum) {

                    System.out.printf("%d + %d = %d%n", i, j, targetNum);
                }else if (i - j == targetNum){

                    System.out.printf("%d - %d = %d%n", i, j, targetNum);
                }
            }
        }
    }
}
