public class Prastevilo {
    public static void main(String[] args) {
        
    }

    public static boolean prastevilo(int n){
        int meja = (int) Math.round(Math.sqrt(n));
        if(n<=1) return false;
        for(int i=2; i<=meja; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
