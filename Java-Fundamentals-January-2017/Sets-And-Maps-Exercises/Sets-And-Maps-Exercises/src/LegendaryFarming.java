import java.util.*;
import java.util.stream.Collectors;

public class LegendaryFarming {

    public static void main(String[] args) {

        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<>();
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();

        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        keyMaterials.put("shards", 0);

        Scanner sc = new Scanner(System.in);

        while (true) {

            String[] input = sc.nextLine().toLowerCase().split(" ");
            boolean isToStop = false;

            for (int i = 0; i < input.length; i++) {

                int quantity = Integer.valueOf(input[i]);
                String materialType = input[i + 1];

                if (materialType.equals("shards") || materialType.equals("fragments") ||
                        materialType.equals("motes")) {

                    keyMaterials.put(materialType, keyMaterials.get(materialType) + quantity);

                    if (keyMaterials.get(materialType) >= 250) {

                        keyMaterials.put(materialType, keyMaterials.get(materialType) - 250);
                        isToStop = true;

                        if (materialType.equals("shards")) {

                            System.out.println("Shadowmourne obtained!");
                        }else if (materialType.equals("fragments")) {

                            System.out.println("Valanyr obtained!");
                        }else {

                            System.out.println("Dragonwrath obtained!");
                        }

                        break;
                    }
                }else {

                    if (!junkMaterials.containsKey(materialType)) {

                        junkMaterials.put(materialType, 0);
                    }

                    junkMaterials.put(materialType, junkMaterials.get(materialType) + quantity);
                }

                i++;
            }

            if (isToStop) {

                break;
            }
        }

        keyMaterials = keyMaterials.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x,y) -> {throw new AssertionError();},
                        LinkedHashMap::new
                ));

        for (String material : keyMaterials.keySet()) {

            int quantity = keyMaterials.get(material);
            System.out.printf("%s: %d\n", material, quantity);
        }

        for (String material : junkMaterials.keySet()) {

            int quantity = junkMaterials.get(material);
            System.out.printf("%s: %d\n", material, quantity);
        }
    }
}
