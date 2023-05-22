import java.util.Objects;
import java.util.Scanner;
import  java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zad12 {
    public static void main(String[] args) {
        Scanner mc =new Scanner(System.in);
        System.out.println("Когда закончите ввод, перейдите на след..строку и введите 'END'");
        while (mc.hasNextLine()) {
            StringBuilder str = new StringBuilder();
            String line = mc.nextLine();
            if (!line.equals("END")) {
                str.append(line).append(System.lineSeparator());
                System.out.println(String.valueOf(str).replaceAll("(\\r|\\n)", ""));
            }
            else{break;}
            String m = String.valueOf(str);
            String [] mas={"эй","депутатик","мужчинка", "сынок","эй ","депутатик ","мужчинка ", "сынок ",
                    "ну ","будем говорить ","значит так ","короче ","типа ","будем говорить","значит так",
                    "короче","типа","\\s+\\s+"};
            for(int i =0;i<mas.length;i++){
                Pattern q1=Pattern.compile(numb(mas,i));
                Matcher textDeda1 = q1.matcher(m);
                while (textDeda1.find()) {
                    if(i <= 7) {
                        m = textDeda1.replaceAll("Алексей Генадьевич");}
                    else if (i > 7 || i <= 16) {
                        m= textDeda1.replaceAll("");
                    } else if (i==17){m= textDeda1.replaceAll(" ");}
                }
            }
            String[] pp = m.split(" ");
            for (int j = 0;j < pp.length-2;j++){
                if (Objects.equals(pp[j], pp[j + 1])){
                    pp[j+1] ="";
                }
                else if (Objects.equals(pp[j], pp[j + 2])){
                    pp[j+2]="";
                }
            }
            m= String.join(" ",pp);
            Pattern q1=Pattern.compile(numb(mas,17));
            Matcher textDeda1 = q1.matcher(m);
            m= textDeda1.replaceAll(" ");
            System.out.println(m);
            System.out.println("");
        }
    }
    public static String numb(String [] m,int n){
        return m[n];
    }
}
