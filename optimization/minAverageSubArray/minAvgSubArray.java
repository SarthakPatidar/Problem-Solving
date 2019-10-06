package optimization.minAverageSubArray;

import java.util.Scanner;

public class minAvgSubArray {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(),k,curr_sum = 0,res_index = 0;

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		k = s.nextInt();
		
		for(int i=0;i<k;i++) {
			curr_sum += arr[i];
		}
		
		int min_sum = curr_sum;
		
		for(int i=k;i<n;i++) {
			curr_sum += arr[i] - arr[i-k];
			
			if(min_sum > curr_sum) {
				min_sum = curr_sum;
				res_index = i-k+1;
			}
		}
		
		System.out.println("Subarray having minimum average lies in index ["+res_index+","+(res_index+k-1)+"]");
		s.close();
	}
}
