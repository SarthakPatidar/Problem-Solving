package optimization.subArraySumLessThenValue;

/*
 * Given Array : [1, 11, 2, 3, 5]
 * Sum : 10
 * Solution : 4 [{1}, {2}, {3}, {2,3}]
 */

import java.util.*;

public class subArraySumLessThenK {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int size, req_sum;
		size = sc.nextInt();
		req_sum = sc.nextInt();
		
		int[] arr = new int[size];
		for(int i=0; i<size; i++)
			arr[i] = sc.nextInt();
		
		int start = 0, end = 0, sum = 0, count = 0;
		
		while(start < size && end < size) {
			if(sum < req_sum) {
				// move end pointer to right
				end++;
				
				// Add it's value to sum
				if(end < size)
					sum += arr[end];
				
				// Number of subarrays will be the length of window
				if(end >= start)
					count += end - start;	
			}
			else {
			 // Move window to right
				sum -= arr[start];
				start++;
			}
		}
		
		sc.close();
		System.out.println("Number of such subarrays = "+count);	
	}
}
