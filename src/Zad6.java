import java.util.Objects;
import java.util.Scanner;
public class Zad6 {
    public static int count_parametr = 18;
    public static void print_text(int i) {
        if (i == 0) {
            System.out.println("Введите страну:");
        }
        if (i == 1) {
            System.out.println("Введите город:");
        }
        if (i == 2) {
            System.out.println("Введите название:");
        }
        if (i == 3) {
            System.out.println("Введите рейтинг:");
        }
        if (i == 4) {
            System.out.println("Введите год создания, если в 2023, то вводи 2022))):");
        }
        if (i == 5) {
            System.out.println("Введите количество сотрудников:");
        }
        if (i == 6) {
            System.out.println("Введите количество сотрудников с профессиональным образованием в области перевода:");
        }
        if (i == 7) {
            System.out.println("Введите количество сотрудников с филологическим образованием:");
        }
        if (i == 8) {
            System.out.println("Введите количество авторов, с которыми сотрудничает издательство:");
        }
        if (i == 9) {
            System.out.println("Введите среднее количество книг выпускаемых в год:");
        }
        if (i == 10) {
            System.out.println("Введите количество бестселлеров:");
        }
        if (i == 11) {
            System.out.println("Введите средний доход в год:");
        }
        if (i == 12) {
            System.out.println("Введите среднюю стоимость 1-ой книги:");
        }
        if (i == 13) {
            System.out.println("Введите расходы на рекламу:");
        }
        if (i == 14) {
            System.out.println("Введите  наличие собственных книжных магазинов:");
        }
        if (i == 15) {
            System.out.println("Введите количество собственных магазинов:");
        }
        if (i == 16) {
            System.out.println("Введите наличие наград:");
        }
        if (i == 17) {
            System.out.println("Введите количество наград:");
        }

    }
    public static void reglam_print(int str, int stol, String [][] text){ //Метод для регламентированного ввода
        Scanner mc=new Scanner(System.in);
        text[str][stol]=mc.next();
    }
    public static void find_information(String[][] ma) { //Метод который ищет нужные данные об издательствах
        String [][] mas=ma;
        String STR = "";
        int k = 1,cnt=0,cntNagrad=0,cntPoryadok=0,cntOsn=0,cntAvtory=0,cntMagaz=0;
        for (int i = 0; i < mas.length; i++) {
            for (int z=0;z<10;z++){//кол-во издательств с цифрами
                if (mas[i][2].contains(String.valueOf(z))){
                    cnt++;break;
                }
            }
            if (Objects.equals(mas[i][16], "Есть")){//nagrady
                cntNagrad++;
            }
            if (Integer.parseInt(mas[i][4])>=1970 & Integer.parseInt(mas[i][4])<=2000){//god_osn
                cntOsn++;
            }
            if (Integer.parseInt(mas[i][15]) >= 1 & Integer.parseInt(mas[i][17]) >= 10){//nagrady i magazin
                cntMagaz++;
            }
            if (Integer.parseInt(mas[i][5]) / Integer.parseInt(mas[i][8])>=0.1){//Otnoshenie
                cntAvtory++;
            }
            String chis1=Integer.toString(Integer.parseInt(mas[i][9])/(2023-Integer.parseInt(mas[i][4]))),chis2=mas[i][12];
            if(chis2.length()==chis1.length()){
                cntPoryadok++;
            }
            STR = mas[i][0];
            STR = "";
            k = 1;
            if (!mas[i][0].equals("")) {//cifri
                STR = "";
                k=1;
                STR = mas[i][0];
                for (int j = i + 1; j < mas.length; j++) {
                    if (STR.equals(mas[j][0])) {
                        mas[j][0] = "";
                        k++;
                    }
                }
                mas[i][0]="";
                System.out.println(STR + "\t" + k);
            }
        }
        System.out.println("Количество изданий, содержащих цифры в названии " + cnt);
        System.out.println("Количество изданий, среднее количество выпускаемых книг в год того же порядка," +
                " что и средняя стоимость 1-ой книги " + cntPoryadok);
        System.out.println("Количество изданий, иимеющих награды " + cntNagrad);
        System.out.println("Количество изданий, с отношением кол-ва сотрудников к авторам меньшим 0.1 " + cntAvtory);
        System.out.println("Количество изданий, основанных в [1970;2000] " + cntOsn);
        System.out.println("Количество изданий, имеющих хотя бы 1 собственный магазин и не менее 10 наград " + cntMagaz);

    }

    public static void main(String[] args) {
        Scanner mc = new Scanner(System.in);
        int count_city;
        int which_print;
        System.out.println("Введите количество издательств, которые хотите заполнить:");
        count_city = mc.nextInt();
        String[][] TEXT = new String[count_city][count_parametr];
        String[][] CONEC = new String[count_city][10];
        System.out.println("Какой ввод будете использовать?" + "\n" +
                "1) Регламентированный" + "\n" +
                "2) Нерегламентированный");
        which_print = mc.nextInt();
        if (which_print == 1){System.out.println("Регламентированный ввод:");
            for (int i = 0;i<count_city;i++){
                for (int j=0;j<count_parametr;j++){
                    print_text(j);
                    reglam_print(i,j,TEXT);
                }
                find_information(TEXT);
            }
        }
        if (which_print == 2) {
            System.out.println("Нерегламентированный ввод, в конце введите 'END' :");
            Scanner pi=new Scanner(System.in);
            int i=0;
            while (pi.hasNextLine()) {
                StringBuilder str = new StringBuilder();
                String line = pi.nextLine();
                if (!line.equals("END")) {
                    str.append(line).append(System.lineSeparator());
                }
                else {break;}
                String [] mas;
                mas = String.valueOf(str).split(";");
                for (int j = 0; j < count_parametr; j++) {
                    TEXT[i][j] = mas[j];
                }
                i++;
            }
            find_information(TEXT);
        }
        else {
            System.out.println("Ввод не верен!!!!!!!!!!!!!, ВВЕДИ 1 или 2) ;))");
        }
    }
    public static void printmas(String[][] ms) {
        for (int i = 0; i < ms.length; i++) {
            for (int j = 0; j < ms[0].length; j++) {
                System.out.print(ms[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
