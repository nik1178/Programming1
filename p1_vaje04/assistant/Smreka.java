import java.util.Scanner;

public class Smreka {
	
	/**
	 * Izpise <stevilo> znakov znaka <znak>.
	 */
	
	private static void znaki(int stevilo, char znak) {
		for (int i = 0; i < stevilo; i++)
			System.out.printf("%c", znak);
	}
	
	/**
	 * Izpise piramido, zamaknjeno za odmik od leve.
	 *
	 * @param n 	visina piramide
	 * @param zamik 	odmik od levega roba
	 */
	
	private static void piramida(int n, int zamik) {
		for (int i = 0; i < n; i++) {
			// risi odmik
			znaki(zamik, '.');
			// risanje presledkov
			znaki(n - i - 1, ' ');	
			// risanje zvezdic
			znaki(2 * i + 1, '*'); 
			System.out.println();	
		}	
	}	
	
	private static void smreka(int stPiramid) {
		for (int visina = 0; visina < stPiramid; visina++)
			piramida(visina + 1, stPiramid - visina - 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stPiramid = sc.nextInt();
		
		smreka(stPiramid);
	}
}