package algorithm.greedy.egyptianFraction;

/*
 * Egyptian Fraction Representation of 2/3 is 1/2 + 1/6
 * 
 * Approach - 
 *   So for 3/4, you'd compute:
 *		 n = ceil(4/3) = 2; remainder = 3/4 - 1/2 = 1/4
 *		 n = ceil(4) = 4; remainder = 1/4 - 1/4 = 0
 *		 3/4 = 1/2 + 1/4
 *
 *	 And for 6/7:
 *		 n = ceil(7/6) = 2; remainder = 6/7 - 1/2 = 5/14
 *		 n = ceil(14/5) = 3; remainder = 5/14 - 1/3 = 1/42
 *		 n = ceil(42) = 42; remainder = 1/42 - 1/42 = 0
 *		 6/7 = 1/2 + 1/3 + 1/42
 */
import java.util.*;

public class EgyptianFraction {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		int numerator = s.nextInt();
		int denominator = s.nextInt();
		findFraction(numerator,denominator);
		
		s.close();
	}
	
	public static void findFraction(int num, int den) {
		
		if(num == 0 || den == 0)
			return;
		
		if(den % num == 0) {
			System.out.print("1/"+(den/num)+"+ ");
			return;
		}
		
		if(num % den == 0)
			return;
		
		if(num > den) {
			System.out.print((num/den)+"+ ");
			findFraction(num % den, den);
			return;
		}
		
		int n = (int) Math.ceil(den/num);
		System.out.print("1/"+n+"+ ");
		findFraction(num*n-den,den*n);	
	}

			
}
