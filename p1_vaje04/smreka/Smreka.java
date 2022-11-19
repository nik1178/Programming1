import java.util.Scanner;
public class Smreka{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        smreka(size);
    }
    public static void smreka(int size){
        for(int i=1; i<=size; i++){
            piramida(i,size-i);
        }
    }

    public static void piramida(int size, int space){
        for(int i=1; i<=size; i++){
            znaki(space, ' ');
            znaki(size-i, ' ');
            znaki(2*i-1, '*');
            System.out.println();
        }
    }

    public static void znaki(int length, char znak){
        for(int i=0; i<length; i++){
            System.out.print(znak);
        }
    }
}