package arrangement.moveZerosToEnd;

import java.util.*;

/*
 * Move all the 0's to the end of an array.
 *		Input : arr[]  = {1, 2, 0, 0, 0, 3, 6};
 *		Output : arr[] = {1, 2, 3, 6, 0, 0, 0};
 */
public class MoveZerosWithoutSwap {
	public static void main(String args[]) {
		int n, count = 0;

		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] != 0)
				arr[count++] = arr[i];
		}

		for (int i = count; i < n; i++) {
			arr[i] = 0;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		s.close();
	}
}
