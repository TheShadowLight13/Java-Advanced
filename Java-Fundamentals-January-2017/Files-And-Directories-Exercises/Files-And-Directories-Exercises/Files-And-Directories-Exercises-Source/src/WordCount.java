import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCount {

    public static void main(String[] args) {

        String wordsPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Word-Count\\words.txt";
        String textPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Word-Count\\text.txt";
        String outputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Word-Count\\results.txt";

        HashMap<String, Integer> countByWord = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(wordsPath))){

            String line = reader.readLine();

            while (line != null) {

                String[] words = line.toLowerCase().split(" ");
                for (int i = 0; i < words.length; i++) {

                    countByWord.put(words[i], 0);
                }

                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(textPath))){

           String line = reader.readLine();

           while (line != null) {

               String[] words = line.toLowerCase().split(" ");

               for (int i = 0; i < words.length; i++) {

                   String currWord = words[i];

                   if (countByWord.containsKey(currWord)) {

                       countByWord.put(currWord, countByWord.get(currWord) + 1);
                   }
               }

               line = reader.readLine();
           }

        } catch (IOException e) {
            e.printStackTrace();
        }

        LinkedHashMap<String, Integer> sortedCountByWord =
                countByWord.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x,y) -> {throw new AssertionError();},
                        LinkedHashMap::new
                ));

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){

            for (String word : sortedCountByWord.keySet()) {

                writer.printf("%s - %d%n", word, sortedCountByWord.get(word));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
