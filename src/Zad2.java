import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Zad2 {
    public static void main(String[] args) {
        Scanner mc = new Scanner(System.in);
        System.out.println("Сколько элементов в вашем числе?");
        int n= mc.nextInt();
        String[] mch = new String[n];
        StringBuilder m = new StringBuilder();
        for (int i = 0; i < n;i++){
            System.out.println("Введите число в 3-ой СС, (0,1,2)");
            mch[i]= mc.next();
            while ((!Objects.equals(mch[i], "0") || !Objects.equals(mch[i], "1") || !Objects.equals(mch[i], "2")) & mch[i].length()!=1){
                System.out.println("Ввод неверен, ещё раз!");
                mch[i]= mc.next();
            }
            m.append(mch[i]);
        }
        int x = 0,k=0;
        while(k!=n){
            for (int i = n-1;i >=0;i--){
                x+=(Integer.parseInt(String.valueOf(m.charAt(i))))*pow(3,k);
                k++;
            }
        }
        String l = "" + x;
        System.out.println("Ввод произведён успешно, переводим ваше число!");
        BigInteger b =new BigInteger(new BigInteger(l).toString(12),10);
        String o= ""+b;
        System.out.println(o);
    }
}
