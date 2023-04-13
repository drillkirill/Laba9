import java.util.Scanner;

public class Zad1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число строк: ");
        int n = scanner.nextInt();

        System.out.print("Введите число столбцов: ");
        int m = scanner.nextInt();

        char[][] matrix = new char[n][m];

        System.out.println("Введите элементы матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.next().charAt(0);
            }
        }

        int[] rowsCount = new int[n];
        int[] columnsCount = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = matrix[i][j];
                if (c == ',' || c == '.' || c == '?') {
                    rowsCount[i]++;
                    columnsCount[j]++;
                }
            }
        }

        System.out.println("По строкам:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Строка %d: %d%n", i, rowsCount[i]);
        }

        System.out.println("По столбцам:");
        for (int j = 0; j < m; j++) {
            System.out.printf("Столбец %d: %d%n", j, columnsCount[j]);
        }
    }
}