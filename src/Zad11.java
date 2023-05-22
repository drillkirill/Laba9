import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zad11 {
    public static void main(String[] args) {
        String strings = "привет всем, рад вас видеть уважаемые коллеги.", strings1 = strings, strings2 = strings, strings3 = strings;
        String[] pr = {"всем", "Всем", "Коллеги", "коллеги"};
        String prZam = "ребятки", delUv = "\\s?(у\\D{8})\\s?";
        Pattern patt;
        Matcher matt;
        for (int i = 0; i < pr.length; i++) {
            patt = Pattern.compile(pr[i]);
            matt = patt.matcher(strings1);
            if (matt.find()) {
                strings1 = matt.replaceAll(prZam);
            }
        }
        System.out.println("1) Замена --- " + strings1);
        System.out.println("2) Все заглавными --- " + strings2.toUpperCase());
        System.out.println("3) Замена регулярными --- " + strings3.replaceAll(delUv, " любимые "));
    }
}
