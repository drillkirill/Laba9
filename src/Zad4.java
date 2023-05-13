import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
import java.lang.String;
public class Zad4 {
    public static void main(String[] args) {
        Scanner mc = new Scanner(System.in);
        System.out.println("Введите размерность, не менее 9");
        int n = mc.nextInt();
        String[][] mas = new String[n][n];
        System.out.println("Заполните строки только числами, символы расставлены, кроме знака '+' или '-'.\n" +
                "Вида «число»^(«число» + или - «число») = «число» или последовательность чисел");
        for (int i = 0; i < n; i++) {
            System.out.println("str");
            for (int j = 0; j < n; j++) {
                if (j == 1) {
                    mas[i][j] = "^";
                    j++;
                }
                if (j == 2) {
                    mas[i][j] = "(";
                    j++;
                }
                if (j == 4) {
                    System.out.println("Введи знак '+' или '-'");
                    mas[i][j] = mc.next();
                    j++;
                }
                if (j == 6) {
                    mas[i][j] = ")";
                    j++;
                }
                if (j == 7) {
                    mas[i][j] = "=";
                    j++;
                }
                mas[i][j] = mc.next();
            }
        }
        int cnt = 0;
        ArrayList<String> ArrayList = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            if (chislo_Li(mas[i][0]) & chislo_Li(mas[i][3]) & chislo_Li(mas[i][5]) & chislo_Li(mas[i][8])
                    & Objects.equals(mas[i][1], "^") & Objects.equals(mas[i][2], "(") & (Objects.equals(mas[i][4], "+") ||
                    Objects.equals(mas[i][4], "-")) & Objects.equals(mas[i][6], ")") & Objects.equals(mas[i][7], "=")) {
                printStr(mas, i);
                if (vivodSTR(mas, i)) {
                    cnt++;
                } else {
                    mas_to_ArrSTR(mas, ArrayList, i);
                }
            } else if (chislo_Li(mas[0][i]) & chislo_Li(mas[3][i]) & chislo_Li(mas[5][i]) & chislo_Li(mas[8][i])
                    & Objects.equals(mas[1][i], "^") & Objects.equals(mas[2][i], "(") & (Objects.equals(mas[4][i], "+") ||
                    Objects.equals(mas[4][i], "-")) & Objects.equals(mas[6][i], ")") & Objects.equals(mas[7][i], "=")) {
                printStol(mas, i);
                if (vivodSTOL(mas, i)) {
                    cnt++;
                } else {
                    masArrSTOL(mas, ArrayList, i);
                }
            }
        }
        System.out.println("Количество верных решений " + cnt + " Исправленные решения:" + "\r");
        printArr(ArrayList);
    }

    public static boolean chislo_Li(String m) {
        if (m == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(m);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static boolean vivodSTR(String[][] m, int o) {
        int i = 8;
        while (i != m.length) {
            for (i = 8; i < m.length; i++) {
                if (Objects.equals(m[o][4], "-")) {
                    if (Math.pow(parseInt(m[o][0]), parseInt(m[o][3]) - parseInt(m[o][5])) == parseInt(m[o][i])) {
                        return true;
                    }
                } else if (Objects.equals(m[o][4], "+")) {
                    if (Math.pow(parseInt(m[o][0]), parseInt(m[o][3]) + parseInt(m[o][5])) == parseInt(m[o][i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    private static boolean vivodSTOL(String[][] m, int o) {
        int i = 8;
        while (i != m.length) {
            for (i = 8; i < m.length; i++) {
                if (Objects.equals(m[4][o], "-")) {
                    if (Math.pow(parseInt(m[4][o]), parseInt(m[4][o]) - parseInt(m[4][o])) == parseInt(m[i][o])) {
                        return true;
                    }
                } else if (Objects.equals(m[4][o], "+")) {
                    if (Math.pow(parseInt(m[0][o]), parseInt(m[3][o]) + parseInt(m[5][o])) == parseInt(m[i][o])) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    public static void printStr(String[][] m, int p) {
        for (int i = 0; i < m.length; i++) {
            System.out.print(m[p][i] + "\t");
        }
        System.out.println("");
    }

    public static void printStol(String[][] m, int p) {
        for (int i = 0; i < m[0].length; i++) {
            System.out.print(m[i][p] + "\t");
        }
        System.out.println("");
    }

    public static void mas_to_ArrSTR(String[][] m, ArrayList<String> kik, int p) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i == 8) {
                if (Objects.equals(m[p][4], "-")) {
                    str.append(Double.toString(Math.pow(parseInt(m[p][0]), parseInt(m[p][3]) - parseInt(m[p][5]))));
                } else if (Objects.equals(m[p][4], "+")) {
                    str.append(Double.toString(Math.pow(parseInt(m[p][0]), parseInt(m[p][3]) + parseInt(m[p][5]))));
                }
            } else {
                str.append(m[p][i]);
            }
        }
        kik.add(String.valueOf(str));
    }

    public static void masArrSTOL(String[][] m, ArrayList<String> kik, int p) {
        StringBuilder arr= new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i == 8) {
                if (Objects.equals(m[4][p], "-")) {
                    kik.add(Double.toString(Math.pow(parseInt(m[0][p]), parseInt(m[3][p]) - parseInt(m[5][p]))));
                } else if (Objects.equals(m[4][p], "+")) {
                    kik.add(Double.toString(Math.pow(parseInt(m[0][p]), parseInt(m[3][p]) + parseInt(m[5][p]))));
                }
            } else {
                arr.append(m[i][p]);
            }
        }
    }

    public static void printArr(ArrayList<String> ar) {
        for (String i:ar){
            System.out.println(i);
        }
    }
}
