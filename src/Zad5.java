import java.util.Scanner;

import java.util.Scanner;
public class Zad5 {
    public static void main(String[] args) {
        Scanner mc = new Scanner(System.in);
        System.out.println("Введите текст");
        String text = mc.nextLine();
        System.out.println("Введите слово");
        String word = mc.nextLine();
        int cntBUKV=0;
        for (int i=0;i<text.length();i++){
            for(int j=0;j<word.length();j++){
                if (text.toCharArray()[i]==word.toCharArray()[j]){
                    cntBUKV++;
                    String m = String.valueOf(text.charAt(i));
                    text=text.replace(m, Integer.toString(j));
                }
            }
        }
        System.out.println(cntBUKV+" раз встречалась буква, текст--- "+text);
    }
}
