import java.util.Scanner;
public class Zad7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();
        String[] sentences = text.split("[!?.]+");

        for (String sentence : sentences) {
            if (sentence.trim().isEmpty()) {
                continue;
            }
            String firstLetter = "" + sentence.charAt(0);
            String lastLetter = "" + sentence.charAt(sentence.length() - 1);
            if (firstLetter.equalsIgnoreCase(lastLetter) && firstLetter.matches("[а-яА-Я]")) {
                String[] words = sentence.split(" ");
                for (int i = words.length - 1; i >= 0; i--) {
                    System.out.print(words[i] + " ");
                }
            } else {
                System.out.print(sentence.trim() + " ");
            }
        }
    }
}
