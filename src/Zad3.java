import java.util.Scanner;

public class Zad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите последовательность символов: ");
        char[] chars = scanner.nextLine().toCharArray();

        // а) Определить количество цифр
        int digitsCount = 0;
        for (char ch : chars) {
            if (Character.isDigit(ch)) {
                digitsCount++;
            }
        }
        System.out.println("Количество цифр: " + digitsCount);

        // б) Выяснить, входит ли в последовательность символ, введенный с клавиатуры,
        //    если входит, то посчитать сколько раз.
        System.out.print("Введите символ для поиска: ");
        char searchChar = scanner.nextLine().charAt(0);
        int searchCount = 0;
        for (char ch : chars) {
            if (ch == searchChar) {
                searchCount++;
            }
        }
        if (searchCount == 0) {
            System.out.println("Символ не найден.");
        } else
            System.out.println("Символ найден " + searchCount + " раз.");

        // в) Выяснить, верно ли, что среди символов имеются все цифры,
        // входящие в цифру, введенную с клавиатуры, например 70293.
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите число для проверки: ");
        String digit = scanner1.nextLine();

        // Переводим введенную цифру в массив символов
        char[] digitChars = digit.toCharArray();

        // Создаем массив для хранения флагов вхождения цифры в массив символов
        boolean[] digitExists = new boolean[10];

        // Проходим по массиву символов и устанавливаем флаги вхождения цифр
        for (char ch : digitChars) {
            if (Character.isDigit(ch)) {
                digitExists[ch - '0'] = true;
            }
        }

        // Проверяем, что все цифры входят в массив символов
        boolean isAllDigitsExists = true;
        for (int i = 0; i < digitExists.length; i++) {
            if (digitExists[i] == false) {
                isAllDigitsExists = false;
                break;
            }
        }
        // Выводим результат
        if (isAllDigitsExists) {
            System.out.println("Массив содержит все цифры из введенного числа.");
        } else {
            System.out.println("Массив не содержит все цифры из введенного числа.");
        }
        // г( Выяснить, имеется ли среди символов пара соседствующих скобок «(, ), {, }, [, ]»
        // если скобки присутствуют в последовательности,
        // то выяснить есть ли закрытые пары разного сочетания и вывести ответ.


        // Проверяем, есть ли скобки в последовательности
        boolean hasBrackets = false;
        for (int i = 0; i < digit.length(); i++) {
            char ch = digit.charAt(i);
            if (ch == '(' || ch == ')' || ch == '{' || ch == '}' || ch == '[' || ch == ']') {
                hasBrackets = true;
                break;
            }
        }

        if (!hasBrackets) {
            System.out.println("Последовательность не содержит скобок.");
            return;
        }

        // Проверяем, есть ли пара соседствующих скобок
        boolean hasPairedBrackets = false;
        int length = digit.length();
        for (int i = 0; i < length - 1; i++) {
            char ch = digit.charAt(i);
            char nextCh = digit.charAt(i + 1);
            if (ch == '(' && nextCh == ')' || ch == '{' && nextCh == '}' || ch == '[' && nextCh == ']') {
                hasPairedBrackets = true;
                break;
            }
        }

        if (!hasPairedBrackets) {
            System.out.println("Последовательность не содержит пары соседствующих скобок.");
            return;
        }

        // Проверяем, есть ли закрытые пары разного сочетания
        boolean hasDifferentPairs = false;
        for (int i = 0; i < length - 1; i++) {
            char ch = digit.charAt(i);
            for (int j = i + 1; j < length; j++) {
                char nextCh = digit.charAt(j);
                if ((ch == '(' && nextCh == ')') || (ch == '{' && nextCh == '}') ||
                        (ch == '[' && nextCh == ']')) {
                    hasDifferentPairs = true;
                    break;
                }
            }
            if (hasDifferentPairs) {
                break;
            }
        }

        // Выводим результат
        if (hasDifferentPairs) {
            System.out.println("Последовательность содержит закрытые пары разного сочетания скобок.");
        } else {
            System.out.println("Последовательность не содержит закрытых пар разного сочетания скобок.");
        }
    }
}

