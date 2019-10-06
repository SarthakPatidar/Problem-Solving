package arrangement.moveZerosToEnd;

import java.util.*;

/*
 * Move all the 0's to the end of an array.
 *		Input : arr[]  = {1, 2, 0, 0, 0, 3, 6};
 *		Output : arr[] = {1, 2, 3, 6, 0, 0, 0};
 */
public class MoveZerosToEndWithSwap {

	public static void main(String args[]) {
		int n, temp, count = 0;

		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				count++;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		s.close();
	}
}
