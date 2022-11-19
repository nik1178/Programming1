import java.util.*;
public class PloscicarPrinted{
    public static void main(String[] args) {
        //Define rows only in max sizes, then calculate how many smaller plates are needed
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        int k = sc.nextInt(); //Max size of plates is 2^k

        int plates = 0;

        int maxSize = (int) Math.pow(2, k);
        
        int currentSize = maxSize;
        int remainingHeight = height;
        while (remainingHeight>0) {
            plates += getRowPlates(currentSize, width) * (remainingHeight/currentSize);
            
            for(int i=0; i<(remainingHeight/currentSize);i++){
                System.out.print(fullThing);
            }
            
            remainingHeight = remainingHeight%currentSize;
            currentSize = currentSize/2;
            
        }
        System.out.println(plates);
    }

    static String fullThing = "";

    private static int getRowPlates(int maxSize, int width) {
        String currentLine = "";
        int currentSize = maxSize;
        int remainingWidth = width;
        int plates = 0;
        while (currentSize>0 && remainingWidth>0) {
            plates += remainingWidth/currentSize * maxSize/currentSize;

            for(int i=0; i<remainingWidth/currentSize*currentSize; i++) {
                if (currentSize<10) {
                    currentLine += currentSize + "" + currentSize;
                } else {
                    currentLine += currentSize;
                }
            }

            remainingWidth = remainingWidth%currentSize;
            currentSize /= 2;
        }


        fullThing = "";
        for(int i=0; i<Character.getNumericValue(currentLine.charAt(0)); i++){
            fullThing += currentLine + "\n";
        }

        fullThing = fix(fullThing, maxSize);

        return plates;
    }

    private static String fix(String fullThing, int maxSize) {
        char[][] array = stringToArray(fullThing);
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                int size = 2;
                while(size<=maxSize){
                    if((i+1)%(size)==0 && array[i][j]==size + '0'){
                        array[i][j] = '-';
                    }
                    if((j+1)%(size*2)==0 && array[i][j]==size + '0'){
                        array[i][j] = '|';
                    }
                    size*=2;
                }
            }
        }

        String newFullThing = "";
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                newFullThing += array[i][j];
            }
            newFullThing += "\n";
        }

        return newFullThing;
    }

    private static char[][] stringToArray(String fullThing) {
        String[] lines = fullThing.split("\n");
        char[][] array = new char[lines.length][lines[0].length()];
        for(int i=0; i<lines.length; i++){
            for(int j=0; j<lines[i].length(); j++){
                array[i][j] = (lines[i].charAt(j));
            }
        }
        return array;
    }
}