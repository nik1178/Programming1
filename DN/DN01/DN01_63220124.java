import java.util.*;
/*Napišite program, ki prebere pozitivni celi števili a in b in izpiše število kvadratov, ki jih tvori mreža a × b
enakomerno razmaknjenih točk. Na primer, pri a = 4 in b = 6 imamo skupaj 26 kvadratov oziroma*/
public class DN01_63220124 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a;
        int b;
        while(true){
            String vnos1 = scan.nextLine();
            String[] vnosa = vnos1.split(" ");
            if(vnosa.length>2) return;
            
            try{
                a = Integer.parseInt(vnosa[0]);
                b = Integer.parseInt(vnosa[1]);
            }catch(Exception e){
                return;
            }
            if(a<2 || a>500 || b<2 || b>500){
                return;
            }
            break;
        }
        if(b>a){
            int temp = a;
            a=b;
            b=temp;
        }
        int counter = 0;
        for(int size=0; size<b; size++){
            for(int horizontal=0; horizontal<a-1-size; horizontal++){
                for(int vertical=0; vertical<b-size-1; vertical++){
                    if(horizontal+size<a) counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
