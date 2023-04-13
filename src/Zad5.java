import java.util.Scanner;

public class Zad5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст: ");
        String text = scanner.nextLine();

        System.out.println("Введите слово: ");
        String word = scanner.nextLine();


        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (word.indexOf(c) != -1) {
                int index = word.indexOf(c) + 1;
                System.out.print(index);
            } else {
                System.out.print(c);
            }
        }
    }
}
