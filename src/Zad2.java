import java.util.Scanner;

public class Zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ввод троичного числа и проверка его корректности
        String input;
        do {
            System.out.print("Введите троичное число (используйте только символы 0, 1 и 2): ");
            input = scanner.nextLine();
        } while (!isInputCorrect(input));

        // перевод троичного числа в 10-ую систему счисления
        int decimal = toDecimal(input);

        // перевод 10-го числа в 12-ую систему счисления
        String output = toBase12(decimal);

        System.out.println(String.format("Введенное число %s (3) = %s (12)", input, output));
    }

    // проверка корректности ввода числа
    private static boolean isInputCorrect(String input) {
        for (char c : input.toCharArray()) {
            if (c != '0' && c != '1' && c != '2') {
                System.out.println("Ошибка! Используйте только символы 0, 1 и 2.");
                return false;
            }
        }
        return true;
    }

    // перевод троичного числа в 10-ую систему счисления
    private static int toDecimal(String input) {
        int decimal = 0;
        int base = 1;
        for (int i = input.length() - 1; i >= 0; i--) {
            int digit = input.charAt(i) - '0';
            decimal += digit * base;
            base *= 3;
        }
        return decimal;
    }

    // перевод 10-го числа в 12-ую систему счисления
    private static String toBase12(int decimal) {
        StringBuilder output = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 12;
            char digit = (char) (remainder < 10 ? '0' + remainder : 'A' + remainder - 10);
            output.insert(0, digit);
            decimal /= 12;
        }
        return output.toString();
    }
}