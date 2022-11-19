import java.util.Scanner;

public class Izstevanka {

	/** 
	 * Vrne indeks otroka, ki izpade.
	 *
	 * @param stOtrok "stevilo (preostalih) otrok
	 * @param stBesed "stevilo besed izstevanke
	 * @return indeks izpadlega otroka
	 */
	 
	private static int kdoIzpade(int stOtrok, int stBesed) {
		return -1;
	}

	/** 
	 * Izloci element z indeksom 'ix' iz tabele 't' tako, da elemente tabele
	 * 't' desno od indeksa 'ix' pomakne za eno mesto v levo.
	 *
	 * @param t tabela z imeni otrok
	 * @param ix indeks izpadlega otroka
	 * @param d efektivna dolzina tabele (do kod se nam splaca pomikati)
	 */
	 
	private static void izloci(String[] t, int ix, int d) {
		
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int stOtrok = sc.nextInt();
		int stBesed = sc.nextInt();

		// preberi imena otrok
		String[] otroci = new String[stOtrok];
		for (int i = 0; i < stOtrok; i++)
			otroci[i] = sc.next();


		// ... 



	}
}
