import java.util.*;

public class Kvadrati{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        while(a<=b){
            System.out.println(a*a);
            a++;
        }
    }
}