import java.util.*;

public class Stevke {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long stevka = sc.nextLong();
		
		while (stevka > 0L) {
			int ostanek = (int) (stevka % 10L);
			System.out.println(ostanek);
			stevka /= 10;
			// stevka = stevka / 10
		}
		
	}
	
}