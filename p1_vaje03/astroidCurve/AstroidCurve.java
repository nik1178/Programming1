import java.util.*;
public class AstroidCurve{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of positive side of graph: ");
        int input=0;
        if(scan.hasNextInt()){
            input=scan.nextInt();
        }else{return;}
        System.out.println(input);

        int size = input*2+1;

        for(int y=0; y<size; y++){
            for(int x=0; x<size; x++){
                if(y==size/2 || x==size/2){
                    if(y==size/2 && x==size-1){
                        System.out.print(">");
                    }else if(y==0 && x==size/2){
                        System.out.print("^");
                    }else if(y==size/2){
                        System.out.print("-");
                    }else{
                        System.out.print("|");
                    }
                    continue;
                }
                if(isAstroid(x-size/2,y-size/2,size)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static boolean isAstroid(int x, int y, int size){
        /* System.out.print(Math.abs(Math.pow(x, 2.0/3))+Math.abs(Math.pow(y, 2.0/3)));
        System.out.println(" -> " + Math.pow(size/2.0, 2.0/3)); */
        if(Math.pow(Math.abs(x), 2.0/3)+Math.pow(Math.abs(y), 2.0/3)<Math.pow(size/2.0, 2.0/3))
            return true;
        
        return false;
    }

    static boolean isCircle(int x, int y, int size){
        /* System.out.print(Math.abs(Math.pow(x, 2.0/3))+Math.abs(Math.pow(y, 2.0/3)));
        Sytstem.out.println(" -> " + Math.pow(size/2.0, 2.0/3)); */
        double radius = size/2.0;
        double distance = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
        if(Math.abs(distance)<=radius)
            return true;
        
        return false;
    }

    static boolean isBicorn(int x, int y, int size){
        double a = size/2;
        double tolerance = size*10;

        if(y*y*(a*a - x*x) > (x*x + 2*a*y - a*a)*(x*x + 2*a*y - a*a) + tolerance)
            return true;
        
        return false;
    }
} 