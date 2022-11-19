import java.util.*;
public class Eksponentna{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("e to the power of: ");
        double x = scan.nextDouble();
        double sum = 0;
        int k = 0;

        //Calculate the first term by hand
        double term = 1;
        sum = term;
        k++;

        while(k<1000){
            term = term * x / k;
            sum = sum + term;
            k++;
        }
        System.out.println(sum);

    }
}