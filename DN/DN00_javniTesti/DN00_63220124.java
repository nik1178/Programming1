import java.util.Scanner;

public class DN00_63220124{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int b = scan.nextInt(); //st bonbonov
        int p = scan.nextInt(); //st prijateljev
        scan.close();

        int vsakDobi = b/p;
        int ostane = b%p;
        System.out.println(vsakDobi);
        System.out.println(ostane);
    }    
}