import java.util.*;
public class Zgoscenke{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //n - How many zgoscenk
        //k - size of zgoscenka
        int n = scan.nextInt();
        int k = scan.nextInt();

        int currentZgoscenka = 1;
        int currentSize = k;

        while(scan.hasNextInt()){
            int current = scan.nextInt();
            if(current > k){
                break;
            }
            currentSize-=current;
            if(currentSize >= 0){
                System.out.println(current + " EP -> zgoscenka " + currentZgoscenka + " (" + (k-currentSize) + " EP)");
            }else{
                currentZgoscenka++;
                if(currentZgoscenka>n) break;
                currentSize = k-current;
                System.out.println(current + " EP -> zgoscenka " + currentZgoscenka + " (" + (k-currentSize) + " EP)");
            }
        }
    }
}