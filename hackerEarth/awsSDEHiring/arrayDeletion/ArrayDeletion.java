/*
 * Given an Array A of N elements.
 * 	Perform Q queries in it. In each query, you select an index I (0-based) and perform the following operation:
 *  for j = I + 1 to N:
 *  	if A[j] < A[I]:
 *  		A[j] = 0
 *  You are required to print the version of A after all Q queries are performed.
 *  
 *  Sample Input
 *  	2
 *  	5 2
 *  	4 3 4 3 2
 *  	3 2
 *  	3 1
 *  	3 2 1
 *  	2
 *  
 *  Sample Output
 *  	4 3 4 0 0
 *  	3 2 1
 */
package hackerEarth.awsSDEHiring.arrayDeletion;

import java.util.*;

public class ArrayDeletion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, q, t;
		Scanner s = new Scanner(System.in);
		t = s.nextInt();

		while (t > 0) {
			n = s.nextInt();
			q = s.nextInt();

			int arr[] = new int[n];
			boolean valid[] = new boolean[n];
			int query[] = new int[q];

			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
				valid[i] = false;
			}

			for (int i = 0; i < q; i++) {
				query[i] = s.nextInt();
				valid[query[i]] = true;
			}

			int max = 0;

			for (int i = 0; i < n; i++) {
				if (arr[i] < max)
					arr[i] = 0;

				else if (valid[i])
					max = arr[i];
			}

			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}

			System.out.println();
			t -= 1;
		}
		s.close();
	}

}
