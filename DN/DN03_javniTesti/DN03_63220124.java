import java.util.*;
public class DN03_63220124{
    public static void main(String[] args) {
        //Define rows only in max sizes, then calculate how many smaller plates are needed
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        int k = sc.nextInt(); //Max size of plates is 2^k

        long plates = 0;

        int maxSize = (int) Math.pow(2, k);
        
        int currentSize = maxSize;
        int remainingHeight = height;
        while (remainingHeight>0) {
            plates += getRowPlates(currentSize, width) * (remainingHeight/currentSize);
            remainingHeight = remainingHeight%currentSize;
            currentSize = currentSize/2;
        }

        System.out.println(plates);
    }

    private static long getRowPlates(int maxSize, int width) {
        int currentSize = maxSize;
        int remainingWidth = width;
        long plates = 0;
        while (currentSize>0 && remainingWidth>0) {
            plates += remainingWidth/currentSize * maxSize/currentSize;
            remainingWidth = remainingWidth%currentSize;
            currentSize/=2;
        }
        return plates;
    }
}