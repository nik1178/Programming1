import java.util.*;

public class NewPetko {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        int k = sc.nextInt(); //Max size of plates is 2^k
        sc.close();

        long plates = 0;
        int maxSize = (int) Math.pow(2, k);

        plates = getPlates(maxSize, height, width, 0);
        
        System.out.println(plates);

    }

    public static long getPlates (int currentSize, int currentHeight, int currentWidth, long plates) {

        if (currentSize < 1) {
            return plates;
        }
        if (currentHeight == 0) return plates;

        if(currentHeight >= currentSize){
            if (currentWidth >= currentSize) {
                plates = getPlates(currentSize, currentSize, currentWidth-currentSize, plates+1);
            } else {
                plates = getPlates(currentSize/2, currentSize, currentWidth, plates);
            }
        }

        if(currentHeight>=currentSize){
            plates = getPlates(currentSize, currentHeight-currentSize, currentWidth, plates);
        }else{
            plates = getPlates(currentSize/2, currentHeight, currentWidth, plates);
        }

        return plates;
    }
}