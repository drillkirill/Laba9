import  java.util.Scanner;
import java.lang.String;

import static java.lang.System.out;

public class Zad10 {
    public static void main(String[] args) {
        Scanner mc = new Scanner(System.in);
        System.out.println("Сколько строк данных?");
        int n = mc.nextInt();
        String [] mas1 = new String [n];
        String [][] mas2 = new String [n][7];
        System.out.println("Введите данные построчно");
        for (int i =0;i<n;i++){
            mas1[i]=mc.next();
        }
        for(int i = 0;i<n;i++){
            for (int j=0;j<7;j++){
                if (j==0){
                    String p = String.join ("", mas1[i]);
                    mas2[i][j]= p.substring(p.indexOf(".")+1,p.indexOf(".",1));
                    StringBuilder g = new StringBuilder(mas1[i]).delete(0,mas1[i].indexOf(".",1));
                    mas1[i]= String.valueOf(g);
                }
                else {
                    String p = String.join("", mas1[i]);
                    if (j == 6) {
                        mas2[i][j] = p.substring(p.indexOf(".")+1, p.indexOf(";"));
                    }
                    else {mas2[i][j] = p.substring(p.indexOf(".")+1, p.indexOf(".", 1));
                        StringBuilder g = new StringBuilder(mas1[i]).delete(0,mas1[i].indexOf(".",1));
                        mas1[i]=String.valueOf(g);}
                }
            }
        }
        int cntPov=0;
        for (int k=0;k<n;){
            for (int i = 0; i<mas2[k][1].length();i++){//авто имеющие те-же буквы что и в номере
                for(int j=0;j<mas2[k][2].length();j++){
                    String marka = mas2[k][1].toString();
                    String numb = mas2[k][2].toString();
                    if(marka.charAt(i)==numb.charAt(j)){
                        cntPov++;break;
                    }
                }
            }
            k++;
        }
        if(cntPov!=0){
            out.println("Количество рейсов, где марка автомобиля, имеет те-же буквы что и в номере = "+cntPov);
        }
        else out.println("Нет таких рейсов");;
        for(int i = 0;i<n;i++){
            int op=Integer.parseInt(mas2[i][4]);
            if(op>2){
                out.println();printmas2(mas2,i);
            }
        }
    }
    public static void printmas2(String[][] array,int i) {
        for (int j=0; j<7; j++) {
            out.print(array[i][j]+"\t");
        }
        out.println();
    }
}
