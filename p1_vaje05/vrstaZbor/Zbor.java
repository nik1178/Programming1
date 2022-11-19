import java.util.*;
public class Zbor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stVojakov = sc.nextInt();
        int[] visine = new int[stVojakov];
        for (int i = 0; i < stVojakov; i++) {
            visine[i] = sc.nextInt();
        }
        boolean vsajEn = false;

        for(int i=0; i<visine.length; i++){
            boolean left = false;
            boolean right = false;
            if(i==0){
                left = true;
            }
            if(i==visine.length-1){
                right = true;
            }
            if(!left && visine[i]>=visine[i-1]){
                left = true;
            }
            if(!right && visine[i]<=visine[i+1]){
                right = true;
            }
            if(left && right){
                vsajEn = true;
                System.out.println(i);
            }
        }

        if(!vsajEn){
            System.out.println("NOBEDEN");
        }
    }
}
