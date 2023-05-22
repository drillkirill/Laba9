import java.util.Scanner;
import java.lang.String;

public class Zad9 {
    public static void main(String[] args) {
        Scanner mc = new Scanner(System.in);
        System.out.println("Введи текст");
        String komm = mc.nextLine();
        System.out.println(komm.replaceAll("\\s?WWW\\s?(\\w*)\\s?W","")
                .replaceAll("\\s?QQQ\\s?(\\w*)\\s?(Q)","")
                .replaceAll("\\s?EEE\\s?(\\w*)\\s?(E)",""));
    }
}
