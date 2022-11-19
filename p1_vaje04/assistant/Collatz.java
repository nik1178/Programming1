import java.util.Scanner;

public class Collatz {
	
	/**
	 * Vrne dolzino Collatzovega zapopredja,ki izhaja iz podanega stevila.
	 */
	
	private static void longestCollatzSeq(int a, int b) {
		
		int maxNum = 0;
		int maxI = 0;
		
			
		for (int i = a; i <= b; i++) {
			int br = dolzinaZaporedja(i);
			if (maxNum < br) {
				maxNum = br;
				maxI = i;
			}
		}	
		
		System.out.printf("%d%n%d%n",maxI, maxNum);
	}
	
	
	private static int dolzinaZaporedja(int stevilo) {
		
		int num = stevilo;
		int n = 1;
		while (num > 1) {
			if( num % 2 == 0 ) {
				num = num / 2;
			} else {
				num = num * 3 +1;
			}
			n++;
		}
		
		return n;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int spMeja = sc.nextInt();
		int zgMeja = sc.nextInt();
		
		longestCollatzSeq(spMeja,zgMeja);
		
	}
}