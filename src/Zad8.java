import java.util.Scanner;
public class Zad8 {
    public static void main(String[] args) {
        Scanner mc = new Scanner(System.in);
        System.out.println("Введи текст");
        String text = mc.nextLine();
        String q = "1", a = "один", w = "2", s = "втор", e = "3", d = "три";
        String m;
        m = text.replace(q, a).replace(w, s).replace(e, d);
        System.out.println(m);
    }
}
