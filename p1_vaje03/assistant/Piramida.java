import java.util.*;

/**
 * n - visina piramide
 *
 *    * 
 *   ***
 *  *****
 *
 */

public class Piramida {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int visina = sc.nextInt();
		
		for (int i = 0; i < visina; i++) {
			// izpis presledkov
			for (int j = 0; j < visina - i - 1; j++) {
				System.out.print(' ');
			}
			// izpis zvezdic
			for (int j = 0; j < i*2 + 1; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		
	}
}