/** Class that prints the Collatz sequence starting from a given number.
 *  @author Mostafa Shehata (AKA: ZeroUser_th)
 */
public class Collatz {

    /** If n is odd ( n % 2 == 1): return ( n * 3 ) + 1, otherwise: return ( n / 2 ) */
    public static int nextNumber(int n) {
        if ((n & 1) == 1) return (n * 3) + 1;
        return n / 2;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

