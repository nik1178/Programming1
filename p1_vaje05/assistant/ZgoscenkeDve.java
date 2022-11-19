import java.util.Scanner;
import java.util.Arrays;

public class ZgoscenkeDve {

	/** ce nam Arrays.toString smrdi... */

	private static String vNiz(int[] t) {
		String result = "[";
		for (int i = 0; i < t.length; i++) {
			if (i > 0)
				result = result + ", ";
			result = result + t[i];
		}
		result = result + "]";
		return result;
	}

	/** Vrne indeks najmanjsega elementa v tabeli. */
	
	private static int indeksMinimuma(int[] t) {
		int iMin = 0;
		for (int i=1; i<t.length; i++) {
			if (t[i] < t[iMin]) {
				iMin = i;
				
			}	
		}
		
		return iMin;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stZgoscenk = sc.nextInt();
		int kapacitetaZgoscenke = sc.nextInt();

		// trenutne zasedenosti posameznih zgoscenk
		
		int[] zasedenosti = new int[stZgoscenk];
		
		while (sc.hasNextInt()) {
			int fileSize = sc.nextInt();
			
			
			int iMin = indeksMinimuma(zasedenosti);
			if (fileSize + zasedenosti[iMin] > kapacitetaZgoscenke){
				break;
			}
			zasedenosti[iMin] += fileSize;
			System.out.printf("%d EP -> zgoscenka %d %s%n",fileSize, iMin+1, Arrays.toString(zasedenosti));
			
		}
		
		
	}
}
