public class TeachPetko {
    public static void main(String[] args) {
        //20 x 17
        // how many 8 ?

        System.out.println(fibonacci(8));

    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
