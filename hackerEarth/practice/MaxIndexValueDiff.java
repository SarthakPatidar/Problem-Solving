package hackerEarth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaxIndexValueDiff {
	public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    
    for(int i=0; i<t; i++) {
        int n = Integer.parseInt(br.readLine());
        String []str = br.readLine().split(" ");
        int []arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        System.out.println(maxValue(arr, n));
    }
	}

	private static int maxValue(int[] arr, int n) {
		
    int minAdd, minSub, maxAdd, maxSub, result;
    
		minAdd = minSub = Integer.MAX_VALUE;
		maxAdd = maxSub = Integer.MIN_VALUE;
		
		for(int i=0; i < n; i++) {
			maxAdd = Math.max(arr[i] + i, maxAdd);
			maxSub = Math.max(arr[i] - i, maxSub);
			minAdd = Math.min(arr[i] + i, minAdd);
			minSub = Math.min(arr[i] - i, minSub);
		}		
		
		result = Math.max(maxAdd - minAdd, maxSub - minSub);
		return result; 		
	}
}
