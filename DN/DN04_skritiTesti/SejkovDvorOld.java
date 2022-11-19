import java.util.*;
public class SejkovDvorOld{
    public static void main(String[] args) {
        // n moskih in n zensk, vsak dobi svojo stevilko
        // k - srecna stevilka, ce je sestevek stevilke moskega in zenske enak k, izpisi
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] moski = new int[n];
        //int[] zenske = new int[n];
        for (int i = 0; i < n; i++) {
            moski[i] = sc.nextInt();
            //zenske[i] = moski[i];
        }

        long kolikoParov = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (moski[i] + moski[j] == k) {
                    kolikoParov++;
                }
            }
        } 

        System.out.println(kolikoParov);
    }
}