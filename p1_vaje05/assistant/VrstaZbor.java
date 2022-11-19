import java.util.Scanner;

public class VrstaZbor {
	
	private static int[] preberiVisine(int n, Scanner sc) {
		int[] visine = new int[n];
		for (int i = 0; i < visine.length; i++) {
			visine[i] = sc.nextInt();
		}
		return visine;
	}
	
	/** 
	 * Vrne true natanko v primeru, ce je element tabele 't' na indeksu 'ix' vecji
	 * ali enak kot njegov levi sosed in hkrati manjsi ali enak kot njegov desni sosed.
	 */
	
	private static boolean lokalnoPravilno(int[] t, int ix) {
		// v.1
		// 3 pogoji 0, zadnji, vmes 
		
		/*
		if (ix == 0 && t[ix] <= t[ix + 1]) {
			return true;
		} else if (ix == t.length - 1 && t[ix - 1] <= t[ix]) {
			return true;
		} else if (t[ix - 1] <= t[ix] && t[ix] <= t[ix + 1]) {
			return true;
		}
		return false;
		*/
		
		// v.2
		
		return (ix == 0 || t[ix-1] <= t[ix])&&
				(ix == t.length-1 || t[ix] <= t[ix+1]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stVojakov = sc.nextInt();
	
		// preberi visine vojakov
		int[] visine = preberiVisine(stVojakov, sc);
	
		// izpisi indekse lokalno pravilno postavljenih (oziroma NOBEDEN)
		boolean vsajEn = false;
		for (int k = 0; k < visine.length; k++) {
			if (lokalnoPravilno(visine, k)) {
				System.out.println(k);
				vsajEn = true;
			}
		}
		if (!vsajEn) {
			System.out.println("NOBEDEN");
		}
	}
}
