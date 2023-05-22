import java.util.Objects;
import java.util.Scanner;


public class Zad3 {
    public static void main(String[] args) {
        Scanner mc = new Scanner(System.in);
        System.out.println("Сколько символов?");
        int n = mc.nextInt();
        String[] mas = new String[n];
        System.out.println("Заполните массив");
        for (int i = 0; i < n; i++) {
            mas[i] = mc.next();
            while (mas[i].length() != 1) {
                System.out.println("Вводи массив по одному!!!");
                mas[i] = mc.next();
            }
        }
        System.out.println("Введите любое число и я скажу, сколько раз оно входит в последовательность");
        String chisB = mc.next();
        System.out.println("Введи число и я скажу, все ли цифры числа входят в последовательность");
        String chisV = mc.next();
        int cntCifr = 0, cntV = 0;
        for (int i = 0; i < n; i++) {
            if (equa(mas[i])) {
                cntCifr++;
            }
        }
        System.out.println("Кол-во цифр " + cntCifr + " Кол-во чисел 'Б' = " + count(String.join("", mas), chisB));
        for (int i = 0; i < chisV.length(); i++) {
            if (cifriVchis(String.join("", mas), chisV)) {
                cntV++;
            }
        }
        if (cntV == chisV.length()) {
            System.out.println("Все цифры присутствуют в последовательности В");
        } else System.out.println("Не все числа присутствуют в последовательности В");

        int cnt = 0;            //Задание Г
        for (int i = 0; i < mas.length - 1; i++) {
            if (Objects.equals(mas[i], "{") & Objects.equals(mas[i + 1], "}")) {
                System.out.println("{,} присутствует в последовательности");
            }
            if (Objects.equals(mas[i], "(") & Objects.equals(mas[i + 1], ")")) {
                System.out.println("(,) присутствует в последовательности");
            }
            if (Objects.equals(mas[i], "[") & Objects.equals(mas[i + 1], "]")) {
                System.out.println("[,] присутствует в последовательности");
            }
            if ((Objects.equals(mas[i], "[") & Objects.equals(mas[i + 1], "}")) ||
                    Objects.equals(mas[i], "(") & Objects.equals(mas[i + 1], "}") ||
                    Objects.equals(mas[i], "[") & Objects.equals(mas[i + 1], ")") ||
                    Objects.equals(mas[i], "{") & Objects.equals(mas[i + 1], ")") ||
                    Objects.equals(mas[i], "(") & Objects.equals(mas[i + 1], "]") ||
                    Objects.equals(mas[i], "{") & Objects.equals(mas[i + 1], "]")) {
                cnt++;
            }
        }
        if (cnt > 0) {
            System.out.println("Есть закрытые скобки других сочетаний 'Г' и их " + cnt);
        } else {
            System.out.println("Закрытых скобок других сочетаний нет 'Г' ");
        }
        //Задание Д
        int cnt1 = 0;
        for (int i = 0; i < mas.length - 1; i++) {
            if (equal(mas, i) & (Objects.equals(mas[i], mas[i + 1]))) {
                cnt1++;
            }
        }
        if (cnt1 > 0) {
            System.out.println("Присутствуют соседствующие знаки препинания 'Д', их " + cnt1);
        } else {
            System.out.println("Нет соседствующих знаков препинания 'Д' ");
        }
        int cnt2 = 0;     //E
        for (int i = 0; i < mas.length - 2; i++) {
            for (int j = i + 1; j < mas.length - 1; j++) {
                if (equa(mas[i]) & equa(mas[i + 1]) & equa(mas[j]) & equa(mas[j + 1])) {
                    if (Integer.parseInt(mas[i]) + 1 == Integer.parseInt(mas[i + 1]) & Integer.parseInt(mas[j]) - 1 ==Integer.parseInt(mas[j + 1])) {
                        cnt2++;
                    }
                }
            }
        }
        if (cnt > 0) {
            System.out.println("Такие последовательности есть 'Е' " + cnt2);
        } else {
            System.out.println("Такие последовательностей нет 'Е' ");
        }
    }
    private static boolean equa(String m) {
        if (m == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(m);
        }
        catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    private static boolean equal(String[] x, int n) {
        if (!Objects.equals(x[n], ".")||!Objects.equals(x[n], ",")||!Objects.equals(x[n], "!")||!Objects.equals(x[n], "?")) {
            return true;
        }
        return false;
    }
    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
    public static boolean cifriVchis(String x, String n){
        for(int i=0;i<n.length();i++) {
            for (int j = 0; j < x.length(); j++) {
                if (x.charAt(j) == n.charAt(i)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static String numb(String [] m,int n){
        return m[n];
    }
}
