package codechef.zcoPractice;

import java.util.*;

public class Tournament {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n;
		long sum=0;
		n = sc.nextInt();
		
		Long arr[] = new Long[n];
		
		for(int i=0;i<n;i++)
			arr[i] = sc.nextLong();
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i=0;i<n;i++)
		{
			sum += arr[i]*((n-i-1) - i);
		}
		
		System.out.print(sum);
		sc.close();
	}
}
