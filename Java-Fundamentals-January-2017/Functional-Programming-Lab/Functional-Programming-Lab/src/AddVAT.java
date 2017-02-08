import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class AddVAT {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            ArrayList<Double> prices = new ArrayList<>();
            String[] tokens = reader.readLine().split(", ");

            for (int i = 0; i < tokens.length; i++) {
                prices.add(Double.valueOf(tokens[i]));
            }

            UnaryOperator<Double> includeVAT = p -> p * 1.20;
            System.out.println("Prices with VAT:");

            for (int i = 0; i < prices.size(); i++) {

               String result = String.format("%.2f", includeVAT.apply(prices.get(i)));
               System.out.println(result.replace(".", ","));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
