import java.util.*;
public class DN02_63220124 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int b = scan.nextInt(); 
        int oblika = b;         //1: ravnovrstnica; 2: kvadratnica; 3: piramidnica; 4: spiralnic

        int d = scan.nextInt();
        int velikost = d;       //[1, 10^4]

        int n = scan.nextInt();
        int kolikoStevil = n;   //[2, 100] 


        int steviloKorakov = 0;
        int prejsnjeStevilo = scan.nextInt();
        for(int i=0; i<n-1; i++){
            int trenutnoStevilo = scan.nextInt();
            switch(oblika){
                case 1: steviloKorakov += ravnovrstnica(velikost, trenutnoStevilo, prejsnjeStevilo); break;
                case 2: steviloKorakov += kvadratnica(velikost, trenutnoStevilo, prejsnjeStevilo); break;
                case 3: steviloKorakov += piramidnica(velikost, trenutnoStevilo, prejsnjeStevilo); break;
                case 4: steviloKorakov += spiralnica(velikost, trenutnoStevilo, prejsnjeStevilo); break;
            }
            prejsnjeStevilo = trenutnoStevilo;
        }
        System.out.println(steviloKorakov);
    }

    static int ravnovrstnica(int velikost, int trenutnoStevilo, int prejsnjeStevilo){
        int steviloKorakov = 0;
        
        steviloKorakov = Math.abs(trenutnoStevilo - prejsnjeStevilo);
        return steviloKorakov;
    }
    static int kvadratnica(int velikost, int trenutnoStevilo, int prejsnjeStevilo){
        int steviloKorakov = 0;
        
        steviloKorakov = Math.abs(trenutnoStevilo%velikost-prejsnjeStevilo%velikost) + Math.abs(trenutnoStevilo/velikost-prejsnjeStevilo/velikost);

        return steviloKorakov;
    }
    static int piramidnica(int velikost, int trenutnoStevilo, int prejsnjeStevilo){
        int steviloKorakov = 0;

        //piramidnica je kvadratnica, samo drugace razporejena, torej je element v vrstici svojega korena floored
        int vrsticaTrenutnega = (int) Math.sqrt(trenutnoStevilo);
        int vrsticaPrejsnjega = (int) Math.sqrt(prejsnjeStevilo);

        /* System.out.println(vrsticaTrenutnega + " " + vrsticaPrejsnjega); */

        //stolpec je polozaj v vrstici + (velikost-vrstica), ampak se da brez velikosti, zato:
        //prvo izracunamo obe vrstici, da lahko izracunamo razliko v vrsticah
        //horizontalni premik je razlika v polozaju v vrstici + razlika v vrsticah

        int polozajTrenutnegaVVrstici = trenutnoStevilo - vrsticaTrenutnega*vrsticaTrenutnega;
        int polozajPrejsnjegaVVrstici = prejsnjeStevilo - vrsticaPrejsnjega*vrsticaPrejsnjega;

        /* System.out.println(polozajTrenutnegaVVrstici + " " + polozajPrejsnjegaVVrstici); */

        int horizontalniKoraki = Math.abs((polozajTrenutnegaVVrstici - polozajPrejsnjegaVVrstici) - (vrsticaTrenutnega - vrsticaPrejsnjega));

        /* System.out.println(horizontalniKoraki); */

        steviloKorakov = horizontalniKoraki + Math.abs(vrsticaTrenutnega-vrsticaPrejsnjega);


        return steviloKorakov;
    }
    static int spiralnica(int velikost, int trenutnoStevilo, int prejsnjeStevilo){
        int steviloKorakov = 0;

        //Enak princip kot spriralnica, v tem da je se zmeraj vse kvadrat enega stevila
        //Ponovno ne rabimo velikosti
        //ce odstejemo vsa stevila znotraj trenutnega obroca, in to stevilo delimo z velikostjo ene stranice, lahko ugotovimo na kateri stranici se nahaja nase trenutno stevilo

        int korenTrenutnega = (int)Math.sqrt( trenutnoStevilo );
        int krogTrenutnega = (korenTrenutnega + korenTrenutnega%2) / 2 ;
        int polozajTrenutnegaNaKrogu = trenutnoStevilo - (Math.max(0, krogTrenutnega*2-1))*(Math.max(0, krogTrenutnega*2-1));
        int velikostStraniceTrenutnega = Math.max(1,(krogTrenutnega*2));
        int stranicaTrenutnega = polozajTrenutnegaNaKrogu/velikostStraniceTrenutnega;
        int polozajTrenutnegaNaStranici = polozajTrenutnegaNaKrogu%velikostStraniceTrenutnega;

        int korenPrejsnjega = (int)Math.sqrt( prejsnjeStevilo );
        int krogPrejsnjega = (korenPrejsnjega + korenPrejsnjega%2) / 2 ;
        int polozajPrejsnjegaNaKrogu = prejsnjeStevilo - (Math.max(0, krogPrejsnjega*2-1))*(Math.max(0, krogPrejsnjega*2-1));
        int velikostStranicePrejsnjega = Math.max(1,(krogPrejsnjega*2));
        int stranicaPrejsnjega = polozajPrejsnjegaNaKrogu/velikostStranicePrejsnjega;
        int polozajPrejsnjegaNaStranici = polozajPrejsnjegaNaKrogu%velikostStranicePrejsnjega;

        //Odmik posameznega od sredine ; gor in desno je pozitivno
        int horizontalenOdmikTrenutnega = 0;
        int vertikalenOdmikTrenutnega = 0;
        if(stranicaTrenutnega == 0){
            horizontalenOdmikTrenutnega = polozajTrenutnegaNaStranici - velikostStraniceTrenutnega/2;
            vertikalenOdmikTrenutnega = krogTrenutnega;
        }else if(stranicaTrenutnega == 1){
            horizontalenOdmikTrenutnega = krogTrenutnega;
            vertikalenOdmikTrenutnega = velikostStraniceTrenutnega/2 - polozajTrenutnegaNaStranici;
        }else if(stranicaTrenutnega == 2){
            horizontalenOdmikTrenutnega = velikostStraniceTrenutnega/2 - polozajTrenutnegaNaStranici;
            vertikalenOdmikTrenutnega = -krogTrenutnega;
        }else{
            horizontalenOdmikTrenutnega = -krogTrenutnega;
            vertikalenOdmikTrenutnega = polozajTrenutnegaNaStranici - velikostStraniceTrenutnega/2;
        }

        int horizontalenOdmikPrejsnjega = 0;
        int vertikalenOdmikPrejsnjega = 0;
        if(stranicaPrejsnjega == 0){
            horizontalenOdmikPrejsnjega = polozajPrejsnjegaNaStranici - velikostStranicePrejsnjega/2;
            vertikalenOdmikPrejsnjega = krogPrejsnjega;
        }else if(stranicaPrejsnjega == 1){
            horizontalenOdmikPrejsnjega = krogPrejsnjega;
            vertikalenOdmikPrejsnjega = velikostStranicePrejsnjega/2 - polozajPrejsnjegaNaStranici;
        }else if(stranicaPrejsnjega == 2){
            horizontalenOdmikPrejsnjega = velikostStranicePrejsnjega/2 - polozajPrejsnjegaNaStranici;
            vertikalenOdmikPrejsnjega = -krogPrejsnjega;
        }else{
            horizontalenOdmikPrejsnjega = -krogPrejsnjega;
            vertikalenOdmikPrejsnjega = polozajPrejsnjegaNaStranici - velikostStranicePrejsnjega/2;
        }

        steviloKorakov = Math.abs(horizontalenOdmikTrenutnega - horizontalenOdmikPrejsnjega) + Math.abs(vertikalenOdmikTrenutnega - vertikalenOdmikPrejsnjega);
        return steviloKorakov;
    }
}