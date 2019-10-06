package spoj.classical;

import java.util.*;

public class Factorial {
	public static void main(String args[]) {
		long t,n,sum;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		while(t > 0) {
			n = sc.nextInt();
			sum = 0;
			while(n > 0) {
				sum += n/5;
				n = n/5;
			}
			System.out.println(sum);
			t -= 1;
		}
		sc.close();
	}
}
