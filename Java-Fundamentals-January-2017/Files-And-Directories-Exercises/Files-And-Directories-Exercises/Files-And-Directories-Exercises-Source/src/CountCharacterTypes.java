import java.io.*;
import java.util.Collections;
import java.util.HashSet;

public class CountCharacterTypes {

    public static void main(String[] args) {

        String inputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Count-Character-Types\\Input.txt";
        String outputPath =
                "F:\\Documents\\ProgrammingFiles\\SoftUni\\Java-Fundamentals-January-2017\\Files-And-Directories-Exercises\\Files-And-Directories-Exercises\\Count-Character-Types\\Output.txt";

        HashSet<Character> vowels = new HashSet<>();
        Collections.addAll(vowels, 'a', 'e', 'i', 'o', 'u');

        HashSet<Character> punctuations = new HashSet<>();
        Collections.addAll(punctuations, '!', '.', '?', ',');

        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputPath))){

            String line = reader.readLine();

            while (line != null) {

                for (int i = 0; i < line.length(); i++) {

                    char currChar = line.charAt(i);

                    if (vowels.contains(currChar)) {

                        vowelsCount++;
                    }else if (punctuations.contains(currChar)){

                        punctuationCount++;
                    }else if (currChar != ' ') {
                        consonantsCount++;
                    }
                }

                line = reader.readLine();
            }

            writer.printf("Vowels: %d%n", vowelsCount);
            writer.printf("Consonants: %d%n", consonantsCount);
            writer.printf("Punctuation: %d", punctuationCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
