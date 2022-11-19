public class Num5 {
    public static void main(String[] args) {
        int a=5;
        int b=3;

        //three var
        int c=a;
        a=b;
        b=c;
        System.out.println("a="+a + " b="+b);

        //two var
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("a="+a + " b="+b);
    }
}
