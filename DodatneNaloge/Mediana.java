import java.util.*;

public class Mediana {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int d = (a <b? (a <c?a: c): (b<c?b:c));
        int e = (a> b? (a> c?a: c) : (b> c?b: c));

        if (a==b || a == c){

            System.out.println(a);

        } else if (a==b || b ==c){
            System.out.println(b);
        } else if (c == b || a == c){
            System.out.println(c);
        } else if (a != d && a != e){
            System.out.println(a);
        } else if (b != d && b != e) {
            System.out.println(b);
        } else {
            System.out.println(c);
        }
    }
}