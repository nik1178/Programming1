import java.util.*;
public class SejkovDvor{
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
        /* for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (moski[i] + zenske[j] == k) {
                    kolikoParov++;
                }
            }
        } */ // tole je n^2

        //Najdemo najvecji indeks v tabeli
        int max = max(moski);

        int[] howMany = new int[max+1];
        for(int i = 0; i < n; i++){
            howMany[moski[i]]++;
        }

        // Compress it down
        int howManyZeroes = 0;
        for(int i = 0; i < howMany.length; i++){
            if(howMany[i] == 0){
                howManyZeroes++;
            }
        }

        int counter = 0;
        int[] compressed = new int[howMany.length - howManyZeroes];
        for (int i = 0; i < howMany.length; i++) {
            if(howMany[i]>0){
                compressed[counter] = i;
                counter++;
            }
        }

        // sortiramo tabelo
        Arrays.sort(compressed);

        //System.out.println(Arrays.toString(compressed));

        // Now we have a compressed array
        // Search for pairs the could make k
        // if k is bigger than 2 * compressed[i], then we only search for compressed[j], where j is bigger than i

        for (int i = 0; i < compressed.length; i++) {
            if(k > 2 * compressed[i]){
                for (int j = i; j < compressed.length; j++) {
                    if(compressed[i] + compressed[j] == k){
                        kolikoParov+=howMany[compressed[i]]*howMany[compressed[j]];
                    }
                }
            }else{
                for (int j = 0; j < compressed.length; j++) {
                    if(compressed[i] + compressed[j] == k){
                        kolikoParov+=howMany[compressed[i]]*howMany[compressed[j]];
                    }
                }
            }
        }

        // ^ Instead of doing this nested for loop, you should just multiply how many people are in i and k-i


        System.out.println(kolikoParov);
    }

    public static int max(int[] tabela) {
        int max = tabela[0];
        for (int i = 1; i < tabela.length; i++) {
            if (tabela[i] > max) {
                max = tabela[i];
            }
        }
        return max;
    }
}