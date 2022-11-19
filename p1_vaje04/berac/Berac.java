import java.util.*;
public class Berac{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int seed = sc.nextInt();
        int miliEvriZaFunt = sc.nextInt();
        int miliEvriZaDolar = sc.nextInt();
        int maksDarilo = sc.nextInt(); //Maksimalno stevilo denarnih enot, ki jih lahko dajo beracu
        int ciljniZnesek = sc.nextInt(); //Koliko EVROV zeli zbrati

        Random random = new Random(seed);


        System.out.printf("%10s %15s%n", "Darilo", "Klobuk");
        int znesekVMiliEvrih = 0;
        while(znesekVMiliEvrih < ciljniZnesek * 1000){
            int valuta = random.nextInt(3); // 0-Evro, 1-Dolar, 2-Funt
            int kolicina = random.nextInt(maksDarilo)+1;
            znesekVMiliEvrih += preracunajVMiliEvre(kolicina, valuta, miliEvriZaDolar, miliEvriZaFunt);
            System.out.printf("%10s %15s%n", kolicina + oznakaValute(valuta), znesekVMiliEvrih);
        }
    }

    public static int preracunajVMiliEvre(int znesek, int valuta, int miliEvriZaDolar, int miliEvriZaFunt){
        int znesekVMiliEvrih = 0;

        switch(valuta){
            case 0:
                znesekVMiliEvrih += znesek * 1000;
                break;
            case 1:
                znesekVMiliEvrih += znesek * miliEvriZaDolar;
                break;
            case 2:
                znesekVMiliEvrih += znesek * miliEvriZaFunt;
                break;
        }

        return znesekVMiliEvrih;
    }

    private static String oznakaValute(int valuta){
        switch(valuta){
            case 0:
                return "€";
            case 1:
                return "$";
            case 2:
                return "£";
            default: 
                return "Napaka";
        }
    }
}