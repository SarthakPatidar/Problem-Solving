package leetCode;

import java.util.*;

public class MaxProductSubArray {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();
		
		int minValue = arr[0];
		int maxValue = arr[0];
		int product = arr[0], temp;
		
		for(int i=1;i<n;i++) {
			
			if(arr[i] < 0) {
				temp = maxValue;
				maxValue = minValue;
				minValue = temp;
			}
			
			maxValue = Math.max(arr[i] * maxValue, arr[i]);
			minValue = Math.min(arr[i] * minValue, arr[i]);
			product = Math.max(product, maxValue);
			
		}
		
		System.out.println("Maximum Product = "+product);
		sc.close();
		
	}
}
