package leetCode;

import java.util.*;

public class MaxSubArraySum {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		int max_sum = arr[0], sum = arr[0];
		
		for(int i=1;i<n;i++) {
			sum = Math.max(arr[i] + sum, arr[i]);
			max_sum = Math.max(sum, max_sum);
		}
		
		System.out.println("Maximum Sum of subarray = "+max_sum);
		sc.close();
	}
}
