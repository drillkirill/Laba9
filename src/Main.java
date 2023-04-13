import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        String line;
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (!line.isBlank()) {
                text.append(line).append("\n");
            }
        }
        String result = removeComments(text.toString());
        if (result.isBlank()) {
            System.out.println("Комментарии отсутствуют.");
        } else {
            System.out.println(result);
        }
    }

    private static String removeComments(String text) {
        String[] patterns = {"WWW.*W", "EEE.*E", "QQQ.*Q"};
        for (String pattern : patterns) {
            text = text.replaceAll(pattern, "");
        }
        return text.trim();
    }
}