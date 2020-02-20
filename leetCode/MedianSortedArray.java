package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MedianSortedArray {
	
	private static double findMedianSortedArrays(int[] a, int[] b) {
		
		double median = 0;
		int n = a.length, m = b.length;
		int minIndex = 0, maxIndex = n, i = 0, j = 0;
		
		while(minIndex <= maxIndex) {
			i = (minIndex + maxIndex)/2;
			j = (n + m + 1)/2 - i;
			
			if(i < n && j > 0 && b[j-1] > a[i])
				minIndex = i+1;
			
			else if(i > 0 && j < m && a[i-1] > b[j])
				maxIndex = i-1;
			
			/*
			 * We reach to our goal condition. (as in Notebook)
			 */
			else {
				if(i == 0)
					median = b[j-1];
				else if(j == 0)
					median = a[i-1];
				else
					median = Math.max(a[i-1], b[j-1]);
				
				break;
			}
		}
		
		if((n+m) % 2 != 0)
			return median;
		else if(i == n)
			median = (median + b[j])/2;
		else if(j == m)
			median = (median + a[i])/2;
		else
			median = (median + Math.min(a[i], b[j]))/2;
		
		return median;
	}	
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double median = 0;
		
		String[] ar1 = br.readLine().split(" ");
		int[] a = Arrays.stream(ar1).mapToInt(Integer::parseInt).toArray();
		
		String[] ar2 = br.readLine().split(" ");
		int[] b = Arrays.stream(ar2).mapToInt(Integer::parseInt).toArray();	
		
		if(a.length < b.length)
			median = findMedianSortedArrays(a,b);
		else
			median = findMedianSortedArrays(b,a);
		
		System.out.println("Median of Sorted Arrays = "+ median);
	}
}