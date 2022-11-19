import java.util.Scanner;
public class Stevke {
    public static void main(String[] args) {
        //Izpise stevke stevila v obratnem vrstnem redu
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        while(n>0){
            System.out.println(n%10);
            n/=10;
        }
    }
}
