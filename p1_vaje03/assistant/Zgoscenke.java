import java.util.*;

public class Zgoscenke {
	
	// n - stevilo zgoscenk
	// capacity - velikost CD-ja v EP
	// fileSize - velikost datoteke v EP
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int capacity = sc.nextInt();
		
		int stZgoscenke = 1;
		int zasedenost = 0;
		while (sc.hasNextInt() && stZgoscenke <= n) {
			int fileSize = sc.nextInt();
			if (fileSize + zasedenost > capacity){
				// datoteka je prevelika -> zamenjaj cd
				stZgoscenke++;
				zasedenost = fileSize;
			} else {
				// pisemo na obstojec cd
				zasedenost+= fileSize;
			}
			if (stZgoscenke <= n) {
				System.out.printf("%d EP -> zgoscenka %d (%d EP)%n", fileSize,  
									stZgoscenke, zasedenost);
			}
		}
	
		
		
		
	}
}