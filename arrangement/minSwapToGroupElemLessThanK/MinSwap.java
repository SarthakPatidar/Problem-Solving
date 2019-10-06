package arrangement.minSwapToGroupElemLessThanK;

import java.util.*;

/*
 * Input:  arr[] = {2, 1, 5, 6, 3}, k = 3
 * Output: 1

 * Explanation: 
 *	  To bring elements 2, 1, 3 together, swap 
 *	  element '5' with '3' such that final array will be :
 *		
 *	  arr[] = {2, 1, 3, 6, 5}
 */

/*
 * Approach
 * 
 *  1) Find count of all elements which are less than or equals to ‘k’. Let’s say the count is ‘cnt’
 *  2) Using two pointer technique for window of length ‘cnt’, each time keep track of how many elements in this range are greater than ‘k’. Let’s say the total count is ‘bad’.
 *  3) Repeat step 2, for every window of length ‘cnt’ and take minimum of count ‘bad’ among them. This will be the final answer.
 */

public class MinSwap {
	public static void main(String args[]) {

		int n, k, bad = 0, count = 0;

		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		k = s.nextInt();

		for (int i = 0; i < n; i++) {
			if (arr[i] <= k) {
				count++;
			}
		}

		for (int i = 0; i < count; i++) {
			if (arr[i] > k) {
				bad++;
			}
		}

		int ans = bad;

		for (int i = 0, j = count; j < n; j++, i++) {

			if (arr[i] > k)
				bad--;

			if (arr[j] > k)
				bad++;

			ans = Math.min(bad, ans);
		}

		System.out.println(ans);
		s.close();
	}
}
