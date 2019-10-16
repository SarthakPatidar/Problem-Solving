package leetCode;

import java.util.*;

public class DuplicateNumber {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		int req_sum = n*(n-1)/2, sum = 0;
		
 		for(int i=0;i<n;i++) {
 			arr[i] = sc.nextInt();
 			sum += arr[i];
 		}
 		
 		System.out.println("Duplicate Number = "+ (sum - req_sum));
 		sc.close();
	}
}
