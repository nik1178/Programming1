public class IntResult{
    public static void main(String[] args) {
        int a = 2000000000;
        int b = 2000000000;
        long c = a;
        long d = b;
        
        System.out.println(4*(a + b));
        System.out.println(
            
            /* (c+d)%Math.pow(2,31) - Math.pow(2,31) * Math.floor((c+d)/Math.pow(2,31)) */

            (4*(c+d)+Math.pow(2,31))%Math.pow(2,32) - Math.pow(2,31)
            
            );
    }
}