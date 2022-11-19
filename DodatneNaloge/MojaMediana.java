import java.util.*;

public class MojaMediana {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();

        int d = b;

        if(a<b && a>c || a>b && a<c){
            d=a;
        }else if(c>b && c<a || c<b && c>a){
            d=c;
        }else if(c==a || b==a){
            d=a;
        }else if(c==b){
            d=b;
        }
        System.out.println(d);
    }
}