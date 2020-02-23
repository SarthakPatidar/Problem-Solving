package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSizeSubArrayOfSumLessThanK {
	
	private static int findMaxSizeSubArray(int[] arr, int k) {
		int sum = 0, maxcnt = 0, cnt = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(sum + arr[i] <= k) {
				sum += arr[i];
				cnt++;
			}
			else
				sum = sum - arr[i-cnt] + arr[i];
			
			maxcnt = (maxcnt < cnt) ? cnt : maxcnt;
		}
		
		return maxcnt;
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int arr[] = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
		int k = Integer.parseInt(br.readLine());
		
		int maxSize = findMaxSizeSubArray(arr,k);
		System.out.println("Max Size of SubArray having sum less than k = "+k+" is = "+maxSize);
	}
}
