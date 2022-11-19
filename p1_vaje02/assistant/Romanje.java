import java.util.Scanner;

public class Romanje {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int pot = sc.nextInt();
		int prehodiPrviDan = sc.nextInt();
		int zmanjsanje = sc.nextInt();
		
		int dan = 1;
		int prehodiDanes = prehodiPrviDan;
		while (pot > 0 && prehodiDanes > 0) {
			if (pot < prehodiDanes) {
				prehodiDanes = pot;
			}
			System.out.println(dan + ": " + pot + " -> " + (pot - prehodiDanes));
			dan++;
			pot -= prehodiDanes;
			prehodiDanes -= zmanjsanje;
		}
	}
}