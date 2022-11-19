import java.util.Scanner;
public class Vsota2{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int vsota = a+b;
        System.out.println(a + " + " + b + " = " + vsota);
    }
}