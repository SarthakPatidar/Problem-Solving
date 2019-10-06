package optimization.maxContiguousSubArraySum;

import java.util.*;

/*
 * Lets take the example:
 *   	{-2, -3, 4, -1, -2, 1, 5, -3}
 *   
 *  Maximum Contiguous Array Sum = 7
 *  	[4 + (-1) + (-2) + 1 + 5]
 */

/*
 * Approach (Kadane's Algorithm)
 * Initialize:
 *   max_so_far = 0
 *   max_ending_here = 0
 *
 * Loop for each element of the array
 * 	(a) max_ending_here = max_ending_here + a[i]
 * 	(b) if(max_ending_here < 0)
 *         max_ending_here = 0
 * 	(c) if(max_so_far < max_ending_here)
 *         max_so_far = max_ending_here
 *		   return max_so_far
 */

public class MaxSum {

	public static void main(String args[]) {

		int max_so_far = 0, max_end_here = 0;

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		for (int i = 0; i < n; i++) {
			max_end_here += arr[i];

			if (max_end_here < 0)
				max_end_here = 0;

			if (max_so_far < max_end_here)
				max_so_far = max_end_here;
		}

		System.out.println(max_so_far);

		s.close();
	}
}
