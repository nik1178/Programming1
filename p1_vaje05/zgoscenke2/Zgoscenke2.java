import java.util.*;

public class Zgoscenke2 {
    public static void main(String[] args) {
        // n - zgoscenk
        // Vsaka zgoscenka k - enot podatkov
        // Datoteko shranimo na zgoscenko, ki ima trenutno najvec prostora
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] zgoscenke = new int[n];

        while (sc.hasNextInt()) {
            int newFileSize = sc.nextInt();
            int mostSpaceIndex = 0;
            for (int i = 0; i < n; i++) {
                if(zgoscenke[i] < zgoscenke[mostSpaceIndex]){
                    mostSpaceIndex = i;
                }
            }
            if (newFileSize + zgoscenke[mostSpaceIndex] <= k) {
                zgoscenke[mostSpaceIndex] += newFileSize;
            }else{
                break;
            }

            System.out.printf("%s EP -> zgoscenka %s %s%n", newFileSize, (mostSpaceIndex+1), Arrays.toString(zgoscenke));
        }
    }
}
