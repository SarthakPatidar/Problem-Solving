package codechef.zcoPractice;

import java.util.Scanner;

public class Ipl {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n,sum = 0;
		
		n = sc.nextInt();
		int arr[]= new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
			sum += arr[i];
		}	
		
		int dp[] = new int[n];
		
		dp[0] = arr[0];
		dp[1] = arr[1];
		dp[2] = arr[2];
		
		for(int i=3; i<n; i++)
		{
			dp[i] = arr[i] + Math.min(dp[i-1], Math.min(dp[i-2], dp[i-3]));
		}
		
		int end = Math.min(n, 3);
		int result = Integer.MAX_VALUE;
		
		for(int i=n-1;i>=n-end;i--)
		{
			result = Math.min(dp[i], result);
		}
		
		System.out.println(sum - result);
		sc.close();
	}
}
