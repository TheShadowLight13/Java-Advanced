import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
import com.sun.org.apache.regexp.internal.RE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CustomComparator {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            ArrayList<Integer> numbers = new ArrayList<>();
            String[] tokens = reader.readLine().split("\\s+");

            for (int i = 0; i < tokens.length; i++) {

                numbers.add(Integer.valueOf(tokens[i]));
            }

            Comparator<Integer> customComparator = createComparator();
            Collections.sort(numbers, customComparator);

            for (Integer number : numbers) {

                System.out.printf("%d ", number);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Comparator<Integer> createComparator() {

        return new Comparator<Integer>() {
            @Override
            public int compare(Integer firstNum, Integer secondNum) {

                final int BEFORE = -1;
                final int EQUAL = 0;
                final int AFTER = 1;

                if (firstNum % 2 == 0 && secondNum % 2 != 0) {
                    return BEFORE;
                }else if (firstNum % 2 != 0 && secondNum % 2 == 0){

                    return AFTER;
                }else if (firstNum % 2 == 0 && secondNum % 2 == 0) {

                    return firstNum.compareTo(secondNum);
                }else if (firstNum % 2 != 0 && secondNum % 2 != 0) {
                    return firstNum.compareTo(secondNum);
                }

                return EQUAL;
            }
        };
    }
}
