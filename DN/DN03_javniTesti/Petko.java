import java.util.Scanner;
import java.lang.Math;
public class Petko {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int S = sc.nextInt();
        int k = sc.nextInt();
        int ostanekV = 0;
        int ostanekS = 0;
        int visinaMAX = 0;
        int sirinaMAX = 0;
        long stranicaMAX = 0;
        long stranica = 0;
        int stevec = 0;
        int najvecV = 0;
        int najvecS = 0;
        int globinaV = 0;
        int globinaS = 0;
        // int globina1 = 0;
        // int globina2 = 0;
        // int globina3 = 0;
        // int globina4 = 0;
        int stevecDelni = 0;
        // int[] ansV = new int[4];
        // int[] ansS = new int[4];
        // int[] ansKot = new int[2];
        // int kvadrantVisina = 0;
        // int kvadrantSirina = 0;
        // int ostanekKvadrantVisina = 0;
        // int ostanekKvadrantSirina = 0;
        // int kvadrantVisinaMAX = 0;
        // int kvadrantSirinaMAX = 0;
        // int stranica2 = 0;
        // int stranica3 = 0;

        ostanekV = V;
        ostanekS = S;
        stranicaMAX = ploscicaMAX(k, stranicaMAX);
        stranica = stranicaMAX;
        sirinaMAX = stranicaMAX(stranica, S);
        visinaMAX = stranicaMAX(stranica, V);
        stevec += najvecS * najvecV; 
        

        //Izracuna ploscice za najvecjo ploskev, sestavljeno samo iz najvecjih ploscic
        while (stranica <= ostanekS){
            if (stranica <= ostanekS){
                ostanekS = (int)(ostanekS - stranica);
                stevec++;
            }
        }
        stevec = stevec * visinaMAX;
        ostanekV -= (int)(visinaMAX * stranica);
        // System.out.println("ostanekS je " + ostanekS);
        // System.out.println("ostanekV je " + ostanekV);

        //izracuna ostale ploscice v isti sirini kot najvecja ploskev
        stevec += prvaVrsta(stranica, ostanekS, stevecDelni, globinaS, visinaMAX);

        //z rekurzijo izracuna ostale vrstice pod najvecjo ploskvo (hopefully)
        if (ostanekV != 0){
            stevec += ostaleVrste(ostanekS, stranica, ostanekV, stevecDelni, sirinaMAX, globinaV, globinaS);
        }
        System.out.println(stevec);
    }

    public static int ostaleVrste (int ostanekS, long stranica, int ostanekV, int stevecDelni, int sirinaMAX, int globinaV, int globinaS) {
        int i = ostanekS;
        int j = globinaS;
        stranica /= 2;
        long stranica1 = stranica;
        if (stranica <= ostanekV){
            ostanekV -= stranica;
            stevecDelni += sirinaMAX * Math.round(Math.pow(2, globinaV));            
        }
        while (ostanekS != 0){
            while (stranica1 <= i){
                if (stranica1 <= i){
                    i -= stranica1;
                    stevecDelni += Math.round(Math.pow(2, j)) * Math.round(Math.pow(2, globinaV));
                }
            }
            j++;
            stranica1 /= 2;
        }
        globinaV++;
        if (stranica != 1){
            stevecDelni += ostaleVrste (ostanekS, (stranica / 2), ostanekV, stevecDelni, sirinaMAX, globinaV, globinaS);
        }
        else {
            return stevecDelni;
        }
        
        return stevecDelni;

    }
    
    public static int prvaVrsta (long stranica, int ostanekS, int stevecDelni, int globinaS, int visinaMAX){
        while (1 < stranica){  
            stranica /= 2;
            globinaS++;
            if (stranica <= ostanekS){    
                ostanekS -= stranica;
                stevecDelni += Math.round(Math.pow(2, globinaS)) * visinaMAX;
            }
        }
        return stevecDelni;
    }

    public static long ploscicaMAX (int k, long stranicaMAX){

        stranicaMAX = 1;
        for (int i = 0; i < k; i++){
            stranicaMAX *= 2;

        }
        return stranicaMAX;
    }

    public static int stranicaMAX (long stranica, int VS){
        VS = (int)(Math.floor(VS / stranica));
        return VS;
    }

    public static int[] polaganje (long stranicaMAX, long stranica, int najvecS, int najvecV, int ostanekV, int ostanekS, int stevec, int globina, int[] ans){
               
        stranica = stranica / 2;
        if (stranica <= ostanekS){
            ostanekS -= stranica;
            stevec += najvecS * Math.round(Math.pow(2, globina));
        }
        if (stranica <= ostanekV){
            ostanekV -= stranica;
            stevec += najvecV * Math.round(Math.pow(2, globina));
        }
        globina++;
        ans[0] = ostanekS;
        ans[1] = (int)(stranica);
        ans[2] = stevec;
        ans[3] = globina;
        return ans;
    }

}
