import java.util.*;

public class DragonArmy {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());

        LinkedHashMap<String, TreeMap<String, ArrayList<Long>>> dragonsNameByType = new LinkedHashMap<>();
        LinkedHashMap<String, List<Double>> averageStatsByDragonType = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = sc.nextLine().split(" ");

            String dragonType = tokens[0];
            String dragonName = tokens[1];
            long damage = tokens[2].equals("null") ? 45 : Long.valueOf(tokens[2]);
            long health = tokens[3].equals("null") ? 250 : Long.valueOf(tokens[3]);
            long armor = tokens[4].equals("null") ? 10 : Long.valueOf(tokens[4]);

            if (!dragonsNameByType.containsKey(dragonType)) {

                dragonsNameByType.put(dragonType, new TreeMap<>());
            }

            dragonsNameByType.get(dragonType).put(dragonName, new ArrayList<>());

            dragonsNameByType.get(dragonType).get(dragonName).add(damage);
            dragonsNameByType.get(dragonType).get(dragonName).add(health);
            dragonsNameByType.get(dragonType).get(dragonName).add(armor);
        }

        for (String dragonType : dragonsNameByType.keySet()) {

            if (!averageStatsByDragonType.containsKey(dragonType)) {

                averageStatsByDragonType.put(dragonType, new ArrayList<>());
            }

            double averageDamage = 0D;
            double averageHealth = 0D;
            double averageArmor = 0D;

            TreeMap<String, ArrayList<Long>> statsByDragonName = dragonsNameByType.get(dragonType);
            int dragonsCount = statsByDragonName.size();

            for (String dragonName : statsByDragonName.keySet()) {

                averageDamage += statsByDragonName.get(dragonName).get(0);
                averageHealth += statsByDragonName.get(dragonName).get(1);
                averageArmor += statsByDragonName.get(dragonName).get(2);
            }

            averageDamage /= dragonsCount;
            averageHealth /= dragonsCount;
            averageArmor /= dragonsCount;

            averageStatsByDragonType.get(dragonType).add(averageDamage);
            averageStatsByDragonType.get(dragonType).add(averageHealth);
            averageStatsByDragonType.get(dragonType).add(averageArmor);
        }

        for (String dragonType : dragonsNameByType.keySet()) {

            List<Double> averageStats = averageStatsByDragonType.get(dragonType);

            double averageDamage = averageStats.get(0);
            double averageHealth = averageStats.get(1);
            double averageArmor = averageStats.get(2);

            System.out.printf("%s::(%.2f/%.2f/%.2f)\n",
                    dragonType, averageDamage, averageHealth, averageArmor);

            TreeMap<String, ArrayList<Long>> statsByDragonName = dragonsNameByType.get(dragonType);

            for (String dragonName : statsByDragonName.keySet()) {

                long damage = statsByDragonName.get(dragonName).get(0);
                long health = statsByDragonName.get(dragonName).get(1);
                long armor = statsByDragonName.get(dragonName).get(2);

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                        dragonName, damage, health, armor);
            }
        }
    }
}
