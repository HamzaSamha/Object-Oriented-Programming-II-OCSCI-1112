import java.util.Scanner;

public class GreatestCommonDenominator{
     public static void main(String[] args) {
       Scanner k = new Scanner(System.in);
       System.out.println("Please enter two integer values.");
       int m = Integer.parseInt(k.next());
       int n = Integer.parseInt(k.next());
       System.out.println("The greatest common divisor of " + m + " and " + n
			+ " is " + GreatestCommonDivisor(m, n));

     }
     private static int GreatestCommonDivisor(int m, int n) {
		if (m % n == 0)
			return n; // Base case
		else // Recursive call
			return GreatestCommonDivisor(n, m % n);
	}










}
