import java.util.Scanner;

public class Zgoscenke {

    public static void main(String[] args) {
        // TODO Auto-generated method stub 500,200,300,600,50
        Scanner vnos = new Scanner(System.in);
        int n = vnos.nextInt(); //n praznih zgoscenk
        int k = vnos.nextInt(); // k kapaciteta zgoscenk
        int cdused=0;
        int cdID=1;
        
        while(vnos.hasNextInt()&&cdID<=n) {
            int filesize=vnos.nextInt();
            if(filesize+cdused>k) {
                cdID++;
                cdused=filesize;
            }
            else cdused+=filesize;
            
            if(cdID<=n) {
                System.out.printf("%d ep -> zgoscenka-%d(%d EP)%n", filesize,cdID,cdused);
            }        
        }

    }

}