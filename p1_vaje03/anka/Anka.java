import java.util.*;
public class Anka{
    public static void main(String[] args) {
        //Prva st. liha
        //Druga st. vecja od m
        //Tretjaj deljiva z d
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int d = scan.nextInt();

        int howManyResults=0;

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                for (int g=0; g<10; g++){
                    if(i%2==1 && j>m && g%d==0){
                        howManyResults++;
                        System.out.println(i+"-"+j+"-"+g);
                    }
                }
            }
        }
        System.out.println(howManyResults);
    }
}