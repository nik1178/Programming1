import java.util.Scanner;
public class Romanje {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int d = scan.nextInt();
        int p = scan.nextInt();
        int z = scan.nextInt();

        int dan = 1;
        while(d>0){
            int newd = d - p + z*(dan-1);
            if(newd<0) newd=0;
            if(newd>=d) break;
            System.out.println(dan++ + ": " + d + " -> " + newd);
            d=newd;
        }

    }
}
