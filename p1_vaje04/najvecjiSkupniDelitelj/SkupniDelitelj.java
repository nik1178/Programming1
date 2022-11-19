import java.util.*;
public class SkupniDelitelj{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int g = scan.nextInt();
        
        int skupniDelitelj = g;
        for(int i=skupniDelitelj; i<n; i+=skupniDelitelj){
            for(int j=i; j<=n; j+=skupniDelitelj){
                if(gcd(i,j)==skupniDelitelj){
                    System.out.println("("+i + ", " + j+")");
                }
            }
        }
            
    }
    public static int gcd (int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
