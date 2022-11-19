import java.util.Scanner;
import java.lang.Math;
public class Petko2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();
        int ostanekVisina = h;
        int ostanekSirina = w;
        long stranicaMAX = 0;
        long stranica = 0;
        int stevecPloscic = 0;
        int najvecVisina = 0;
        int najvecSirina = 0;
        int globina1 = 1;
        int globina2 = 1;
        int globina3 = 0;
        int globina4 = 0;
        int stevecDelni = 0;
        int[] ansV = new int[4];
        int[] ansS = new int[4];
        int[] ansKot = new int[2];
        int kvadrantVisina = 0;
        int kvadrantSirina = 0;
        int ostanekKvadrantVisina = 0;
        int ostanekKvadrantSirina = 0;
        int kvadrantVisinaMAX = 0;
        int kvadrantSirinaMAX = 0;
        int stranica2 = 0;
        int stranica3 = 0;
        sc.close();

        if (k == 0){
            stevecPloscic = h * w;
        }
        else {
            stranicaMAX = stranicaMAX (k, stranica);
            stranica = stranicaMAX;
            najvecVisina = (int)(h / stranica);
            najvecSirina = (int)(w / stranica);
            // System.out.println("najvecSirina je " + najvecSirina);
            // System.out.println("najvecVisina je " + najvecVisina);
            
            ostanekVisina -= najvecVisina * stranica;
            ostanekSirina -= najvecSirina * stranica;
            stevecPloscic += najvecVisina * najvecSirina;
            // System.out.println(stevecPloscic);

            if (ostanekVisina != 0 && ostanekSirina != 0){
                kvadrantSirina = ostanekSirina;
                kvadrantVisina = ostanekVisina;
                ostanekKvadrantSirina = kvadrantSirina;
                ostanekKvadrantVisina = kvadrantVisina;
                // System.out.println("ostanekKvadrantSirina je " + ostanekKvadrantSirina);
                // System.out.println("ostanekKvadrantVisina je " + ostanekKvadrantVisina);
            }


            while (ostanekSirina != 0){
                ansS = polaganjeSirina(ostanekSirina, stranica, stevecDelni, najvecVisina, globina1, ansS);
                ostanekSirina = ansS[0];
                stranica = ansS[1];
                stevecPloscic += ansS[2];
                globina1 = ansS[3];
            }

            
            stranica = stranicaMAX;

            while (ostanekVisina != 0){
                ansV = polaganjeVisina(ostanekVisina, stranica, stevecDelni, najvecSirina, globina2, ansV);
                ostanekVisina = (ansV[0]);
                stranica = (ansV[1]);
                stevecPloscic += (ansV[2]);
                globina2 = (ansV[3]);
            }

            if (h - (najvecVisina * stranica) != 0 && w - (najvecSirina * stranica) != 0){
                stranica = stranicaMAX / 2;
                najvecVisina = (int)(h / stranica);
                najvecSirina = (int)(w / stranica);
                ostanekVisina -= najvecVisina * stranica;
                ostanekSirina -= najvecSirina * stranica;
                stevecPloscic += najvecVisina * najvecSirina;

                while (ostanekSirina != 0){
                    ansS = polaganjeSirina(ostanekSirina, stranica, stevecDelni, najvecVisina, globina1, ansS);
                    ostanekSirina = ansS[0];
                    stranica = ansS[1];
                    stevecPloscic += ansS[2];
                    globina1 = ansS[3];
                }
    
                stranica = stranicaMAX;
    
                while (ostanekVisina != 0){
                    ansV = polaganjeVisina(ostanekVisina, stranica, stevecDelni, najvecSirina, globina2, ansV);
                    ostanekVisina = (ansV[0]);
                    stranica = (ansV[1]);
                    stevecPloscic += (ansV[2]);
                    globina2 = (ansV[3]);
                }



            }

            // System.out.println(stevecPloscic);
            kvadrantSirinaMAX = (int)(kvadrantSirina / (stranicaMAX / 2));
            kvadrantVisinaMAX = (int)(kvadrantVisina / (stranicaMAX / 2));
            // System.out.println("kvadrantSirinaMAX je " + kvadrantSirinaMAX);
            // System.out.println("kvadrantVisinaMAX je " + kvadrantVisinaMAX);
            
            stevecPloscic += (kvadrantSirinaMAX * kvadrantVisinaMAX);
            ostanekKvadrantSirina -= kvadrantSirinaMAX;
            ostanekKvadrantVisina -= kvadrantVisinaMAX;
            stranica = stranicaMAX;

            while (ostanekKvadrantSirina != 0){
                ansS = polaganjeSirina(ostanekKvadrantSirina, stranica, stevecDelni, kvadrantVisinaMAX, globina3, ansS);
                ostanekKvadrantSirina = (ansS[0]);
                stranica = (ansS[1]);
                stevecPloscic += (ansS[2]);
                globina3 = (ansS[3]);
            }
            
            stranica = stranicaMAX;


            while (ostanekKvadrantVisina != 0){
                ansV = polaganjeVisina(ostanekKvadrantVisina, stranica, stevecDelni, kvadrantSirinaMAX, globina4, ansV);
                ostanekKvadrantVisina = (ansV[0]);
                stranica = (ansV[1]);
                stevecPloscic += (ansV[2]);
                globina4 = (ansV[3]);
            }
            System.out.println("globina3 je " + globina3);
            System.out.println("globina4 je " + globina4);
            if ((h - najvecVisina * stranicaMAX) != 0 && (w - najvecSirina * stranicaMAX) != 0){
                ansKot = polaganjeKot(k, globina3, globina4, ansKot);
                stranica2 = ansKot[0];
                stranica3 = ansKot[1];
                stevecPloscic += stranica2 * stranica3;

            }
        }
        System.out.println(stevecPloscic);
    }



    public static long stranicaMAX (int k, long stranicaMAX){

        stranicaMAX = 1;
        for (int i = 0; i < k; i++){
            stranicaMAX *= 2;

        }
        return stranicaMAX;
        /*izracuna stranico najvecje plosice (2^k)*/
    }

    public static int[] polaganjeSirina (int ostanekSirina, long stranica, int stevecDelni, int najvecVisina, int globina1, int[] ans){
        stranica = stranica / 2;
        if (stranica <= ostanekSirina){
            ostanekSirina -= stranica;
            stevecDelni += najvecVisina * Math.round(Math.pow(2, globina1));
        }
        globina1++;
        ans[0] = ostanekSirina;
        ans[1] = (int)(stranica);
        ans[2] = stevecDelni;
        ans[3] = globina1;
        return ans;
    }


    public static int[] polaganjeVisina (int ostanekVisina, long stranica, int stevecDelni, int najvecSirina, int globina2, int[] ans){
        stranica = stranica / 2;
        if (stranica <= ostanekVisina){
            ostanekVisina -= stranica;
            stevecDelni += najvecSirina * Math.round(Math.pow(2, globina2));
        }
        globina2++;
        ans[0] = ostanekVisina;
        ans[1] = (int)(stranica);
        ans[2] = stevecDelni;
        ans[3] = globina2;
        return ans;
    }


    public static int[] polaganjeKot (int k, int globina3, int globina4 ,int[] ansKot){
		ansKot[0] = (int)(Math.round(Math.pow(2, k - globina3)));
		ansKot[1] = (int)(Math.round(Math.pow(2, k - globina4)));
        return ansKot;
		
	}   





}
