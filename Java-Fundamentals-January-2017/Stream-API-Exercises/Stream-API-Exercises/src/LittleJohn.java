import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LittleJohn {

     static int smallArrowsCount = 0;
     static int midArrowsCount = 0;
     static int bigArrowsCount = 0;

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String smallArrow = ">----->";
            String midArrow = ">>----->";
            String bigArrow = ">>>----->>";

            int n = 4;

            for (int i = 0; i < n; i++) {

                StringBuilder line = new StringBuilder(reader.readLine());
                line = countAndRemoveArrowType(line, bigArrow);
                line = countAndRemoveArrowType(line, midArrow);
                countAndRemoveArrowType(line, smallArrow);
            }

            String concatenatedArrowsCount = String.valueOf(smallArrowsCount) + midArrowsCount + bigArrowsCount;

            StringBuilder result = new StringBuilder();
            result.append(Integer.toBinaryString(Integer.valueOf(concatenatedArrowsCount)));
            StringBuilder reversedResult = new StringBuilder(result).reverse();
            result.append(reversedResult.toString());

            System.out.println(Integer.parseInt(result.toString(), 2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder countAndRemoveArrowType(StringBuilder line, String arrowType) {

        Pattern pattern = Pattern.compile(arrowType);
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {

            if (arrowType.equals(">>>----->>")) {

                bigArrowsCount++;
            }else if (arrowType.equals(">>----->")) {

                midArrowsCount++;
            }else if (arrowType.equals(">----->")){
                smallArrowsCount++;
            }

            line = new StringBuilder(line.toString().replaceFirst(arrowType, " "));
        }
        return line;
    }
}
