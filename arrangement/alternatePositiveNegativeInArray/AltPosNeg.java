package arrangement.alternatePositiveNegativeInArray;

import java.util.*;

/*
 * Problem Description :
 * 	Given an array of positive and negative numbers, 
 * 	arrange them in an alternate fashion such that every positive number 
 * 	is followed by negative and vice-versa maintaining the order of appearance.
 *	 
 *	Number of positive and negative numbers need not be equal. 
 *	If there are more positive numbers they appear at the end of the array.
 *	If there are more negative numbers, they too appear in the end of the array.
 *
 * Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
 * Output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0} 
 */
public class AltPosNeg {
	public static void main(String ars[]) {
		
		int n,temp;
		
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int left = 0,right = n-1;
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = s.nextInt();
		s.close();
		
		/* Logic to move all negative elements at the end */
		while(right > left)
		{
			while(arr[left++] > 0);
			while(arr[right--] < 0);
			if(right > left) 
			{
				 temp = arr[right];
				 arr[right] = arr[left];
				 arr[left] = temp;
			}			
		}
		
		/* Now left points to leftmost negative element.
		 * Check if :
		 * 		left = 0 [All the elements are positive]
		 *    left = n [All the elements are negative]
		 */
		if(left == 0 || left == n)
			return;
		
		/* 
		 * Place them in alternate position
		 * 	1) Positives at Odd Index
		 * 	2) Negatives at Even Index
		 */
		int k = 0;
		while(left < n) 
		{
			if(arr[k] > 0) {
				 temp = arr[k];
				 arr[k] = arr[left];
				 arr[left] = temp;				
			}
			k += 2;
			left += 1;
		}
		
		for(int i=0;i<n;i++)
			System.out.print(arr[i] + " ");		
	}
}
