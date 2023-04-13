import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zad8 {
    public static void main(String[] args) {
        String text = "1 кот и 2 день.";
        Pattern pattern = Pattern.compile("[123]");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int digit = Integer.parseInt(matcher.group());
            String word = getWordForDigit(digit);
            text = text.replaceAll(String.valueOf(digit), word);
        }
        System.out.println(text);
    }

    private static String getWordForDigit(int digit) {
        switch (digit) {
            case 1:
                return "один";
            case 2:
                return "втор";
            case 3:
                return "три";
            default:
                return "";
        }
    }
}