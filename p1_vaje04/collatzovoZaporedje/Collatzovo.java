import java.util.*;
public class Collatzovo{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        int last = scan.nextInt();

        int biggestIndex = first;
        int biggestLength = 0;
        for(int i=first; i<=last; i++){
            int count = collatzLength(i);
            
            if(count>biggestLength){
                biggestLength = count;
                biggestIndex = i;
            }
        }
        System.out.println(biggestIndex);
        System.out.println(biggestLength);
    }

    static int collatzLength(int n){
        int count = 0;
        while(n!=1){
            if(n%2==0){
                n = n/2;
            }else{
                n = 3*n+1;
            }
            count++;
        }
        count++;
        return count;
    }
}