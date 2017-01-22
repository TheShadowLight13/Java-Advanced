import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int operationsCount = Integer.valueOf(console.nextLine());

        String previousTextState = "";

        StringBuilder text = new StringBuilder();
        Stack<String> textChanges = new Stack<>();

        for (int i = 0; i < operationsCount; i++) {

            String[] commands = console.nextLine().split(" ");
            int operationType = Integer.valueOf(commands[0]);

            switch (operationType) {

                case 1:

                    previousTextState = text.toString();
                    textChanges.push(previousTextState);

                    String appendText = commands[1];
                    text.append(appendText);
                    break;

                case 2:

                    previousTextState = text.toString();
                    textChanges.push(previousTextState);

                    int countToErase = Integer.valueOf(commands[1]);
                    for (int j = 0; j < countToErase; j++) {

                        text.deleteCharAt(text.length() - 1);
                    }

                    break;

                case 3:

                    int index = Integer.valueOf(commands[1]) - 1;
                    System.out.println(text.charAt(index));
                    break;

                case 4:

                    String previousText = textChanges.pop();
                    text = new StringBuilder(previousText);
                    break;
            }
        }
    }
}
