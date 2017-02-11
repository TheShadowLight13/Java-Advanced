import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class OfficeStuff {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            TreeMap<String, LinkedHashMap<String, Integer>> staffsByCompany = new TreeMap<>();

            int n = Integer.valueOf(reader.readLine());

            for (int i = 0; i < n; i++) {

                String input = reader.readLine();
                input = input.substring(1, input.length() - 1);
                String[] tokens = input.split("[-\\s+]+");

                String company = tokens[0];
                Integer quantity = Integer.valueOf(tokens[1]);
                String staff = tokens[2];

                staffsByCompany.putIfAbsent(company, new LinkedHashMap<>());
                staffsByCompany.get(company).putIfAbsent(staff, 0);
                int newQuantity = staffsByCompany.get(company).get(staff) + quantity;
                staffsByCompany.get(company).put(staff, newQuantity);
            }

            for (String company : staffsByCompany.keySet()) {

                System.out.printf("%s: ", company);
                LinkedHashMap<String, Integer> quantityByStaff = staffsByCompany.get(company);

                StringBuilder quantityByStaffResult = new StringBuilder();
                quantityByStaff.entrySet().forEach(e ->{
                    quantityByStaffResult.append(e.getKey());
                    quantityByStaffResult.append("-");
                    quantityByStaffResult.append(e.getValue());
                    quantityByStaffResult.append(", ");
                });

                quantityByStaffResult.delete(quantityByStaffResult.length() - 2, quantityByStaffResult.length());
                System.out.println(quantityByStaffResult);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
