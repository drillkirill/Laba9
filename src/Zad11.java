import java.util.Arrays;

public class Zad11 {
    public static void main(String[] args) {

        String[] stringArray = {"Привет", "мир", "как дела?"};

        // Удаление пробелов в начале и конце строк
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].trim();
        }

        System.out.println(Arrays.toString(stringArray));

        // Замена символов ! на ?
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].replaceAll("!", "?");
        }

        System.out.println(Arrays.toString(stringArray));

        // Удаление всех цифр из строк
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].replaceAll("\\d", "");
        }

        System.out.println(Arrays.toString(stringArray));
    }
}