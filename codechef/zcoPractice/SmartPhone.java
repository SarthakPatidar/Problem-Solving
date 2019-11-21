package codechef.zcoPractice;

import java.util.*;

public class SmartPhone {
	public static void main(String args[])
	{
		int n,index;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();index = 0;
		
		long arr[] = new long[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextLong();
		}
		
		Arrays.sort(arr);

		long max = 0;
		for(int i=0;i<n;i++)
		{
			if(arr[i] == 0)
				index++;
		}
		
		for(int i=(n-index); i>0;i--)
		{
			long elem = arr[n-i] * i;
			if(elem > max)
			  max = elem;
			else if(elem <= max)
				break;
		}
		
		System.out.println(max);
		
		sc.close();
		
		
	}
}
