package codechef.zcoPractice;

import java.util.*;

public class Supw {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int arr[]= new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		for(int i=n-4; i>= 0; i--)
		{
			arr[i] += Math.min(arr[i+1], Math.min(arr[i+2], arr[i+3]));
		}
		
		int end = Math.min(n, 3);
		int result = Integer.MAX_VALUE;
		
		for(int i=0;i<end;i++)
		{
			result = Math.min(arr[i], result);
		}
		
		System.out.println(result);
		sc.close();
	}
}
