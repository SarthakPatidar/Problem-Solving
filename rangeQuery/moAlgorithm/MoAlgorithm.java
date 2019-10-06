package rangeQuery.moAlgorithm;

import java.util.*;

/*
 * To find sum of elements in a given range for different queries.
 * 		Input:  arr[]   = {1, 1, 2, 1, 3, 4, 5, 2, 8};
 *         		query[] = [0, 4], [1, 3] [2, 4]
 *         
 * 		Output: Sum of arr[] elements in range [0, 4] is 8
 *          	Sum of arr[] elements in range [1, 3] is 4  
 *          	Sum of arr[] elements in range [2, 4] is 6
 */
public class MoAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);

		// Number of elements in an array
		int n = s.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		// Number of queries
		int m = s.nextInt();
		int currL = 0, currR = 0, currSum = 0;

		List<Query> qList = new ArrayList<Query>();

		for (int i = 0; i < m; i++) {
			int l = s.nextInt();
			int r = s.nextInt();

			Query q = new Query(l, r, i, n);
			qList.add(q);
		}

		// Sorting is done using Comparable Interface
		Collections.sort(qList);

		for (int i = 0; i < m; i++) {

			int left = qList.get(i).l;
			int right = qList.get(i).r;

			while (currL < left) {
				currSum -= arr[currL];
				currL++;
			}

			while (currL > left) {
				currSum += arr[currL];
				currL--;
			}

			while (currR <= right) {
				currSum += arr[currR];
				currR++;
			}

			while (currR > right + 1) {
				currSum -= arr[currR];
				currR--;
			}

			System.out.println("--------------------------");
			System.out.println("Left -> " + qList.get(i).l);
			System.out.println("Right -> " + qList.get(i).r);
			System.out.println("Sum = " + currSum);
			System.out.println("--------------------------");

		}
		s.close();
	}
}
