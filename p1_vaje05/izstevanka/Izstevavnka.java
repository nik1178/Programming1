import java.util.*;
public class Izstevavnka {
    public static void main(String[] args) {
        // Otroci v vrsti
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Stevilo otrok
        int b = sc.nextInt(); // Stevilo "besed", torej kateri otrok gre ven vsak krog

        int d = n; // Efektivna dolzina tabele otrok, saj ko enega vrzemo ven, se dolzina tabele zmanjsa, ampak tabele se ne spreminjajo

        sc.nextLine(); // Tell scanner to go to next line
        String[] otroci = sc.nextLine().split(" "); // Tabela otrok

        while (d>1) {
            int indeksZaOdstranit = (b-1)%d;
            /* System.out.println("Goodbye moonman " + otroci[indeksZaOdstranit]); */
            System.out.println(otroci[indeksZaOdstranit]);
            for (int i = indeksZaOdstranit; i < otroci.length-1; i++) {
                otroci[i] = otroci[i+1];
            }
            
            d--;

            /* System.out.println(Arrays.toString(otroci)); */
        }
    }
}
