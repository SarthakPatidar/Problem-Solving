package leetCode;

import java.util.*;

public class UglyNumberGeneration {

	static int maxVal = 2 * 1000000000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t,n,a,b,c,result;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		while(t > 0) {
			n = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			result = getUglyNumber(n, a, b, c);
			System.out.println(result);
			t--;
		}
		
		sc.close();
	}

	private static int getUglyNumber(int n, int a, int b, int c) {
		// TODO Auto-generated method stub
		int high = maxVal,mid,pos,result=0;
		int low = 0;
		
		while(low <= high) {
			mid = low + (high-low)/2;
			pos = (int)(mid/a + mid/b + mid/c - mid/lcm(a,b) - mid/lcm(b,c) - mid/lcm(a,c) + mid/lcm(a, lcm(b,c)));
			
			if(pos >= n) {
				high = mid - 1;
				result = mid;
			}
			else {
				low = mid + 1;
			}
		}
		
		return result;
	}

	private static long lcm(long a, long b) {
		// TODO Auto-generated method stub
		return a * b / gcd(a,b);
	}

	private static long gcd(long a, long b) {
		// TODO Auto-generated method stub
		if(a == 0)
			return b;
		return gcd(b % a, a);
	}

}
