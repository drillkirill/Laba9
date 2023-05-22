import java.util.Scanner;

public class Zad7 {
    public static void main(String[] args) {
        Scanner mc = new Scanner(System.in);
        System.out.println("Введи текст");
        String text = mc.nextLine();
        String[] array = text.split(" ");
        String zxxz = "";
        if (text.charAt(0)==text.charAt(text.length()-1)){
            for (int i = array.length - 1; i >= 0; i--) {
                zxxz += array[i] + " ";
            }
            System.out.println("Перевернул " + zxxz);
        }
        else System.out.println("Не перевернул " + zxxz);
    }
}
