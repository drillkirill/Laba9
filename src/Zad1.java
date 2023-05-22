import java.util.Objects;
import java.util.Scanner;
public class Zad1 {
    public static void main(String[] args) {
        Scanner mc = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        System.out.println("Введите размерность матрицы M*N");
        int m =mc.nextInt(), n=mc.nextInt(),cnt1=0, cnt2=0, cnt3=0;
        String [][] mas_1= new String [m][n];
        for (int i=0;i < m;i++){
            for (int j=0;j < n;j++){
                System.out.println("Вводите по одному символу!!!");
                mas_1[i][j]=str.next();
                while(mas_1[i][j].length()!=1){
                    System.out.println("Вводите по одному символу!!!");
                    mas_1[i][j]=str.next();
                }
            }
        }
        for (int i=0;i < m;i++){
            for (int j=0;j < n;j++){
                if (Objects.equals(mas_1[i][j], ",")){cnt1++;}
                if (Objects.equals(mas_1[i][j], ".")){cnt2++;}
                if (Objects.equals(mas_1[i][j], "?")){cnt3++;}
            }
        }
        System.out.println("Количество символов (,) = " + cnt1 +" Количество символов (.) = " + cnt2 + " Количество символов (?) = " + cnt3);
    }
}
