package codechef.zcoPractice;

import java.util.*;

public class Variation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n,k,sum;
		n = sc.nextInt();
		k = sc.nextInt();
		sum = 0;
		
		Integer arr[] = new Integer[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if((arr[i] - arr[j]) >= k)
				{
					sum += n-j;
				  break;					
				}
			}
		}
		
		System.out.print(sum);
		sc.close();
		
		
	}

}
