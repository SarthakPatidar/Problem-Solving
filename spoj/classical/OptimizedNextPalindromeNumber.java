package spoj.classical;

import java.util.*;

public class OptimizedNextPalindromeNumber {

	public static void getNextPalindromeNumber(int[] arr, int n) {
		if (all9s(arr)) {
			System.out.print("1");
			for (int i = 0; i < n - 1; i++) {
				System.out.print("0");
			}
			System.out.print("1");
		} else {
			getNextPalindromeNumberUtility(arr, n);
		}
		System.out.println();
	}

	private static void getNextPalindromeNumberUtility(int[] arr, int n) {
		// TODO Auto-generated method stub
		int mid = n / 2;
		int right = (n % 2 == 0) ? mid : mid + 1;
		int left = mid - 1;
		boolean leftSmaller = false;

		while (left >= 0 && arr[left] == arr[right]) {
			left--;
			right++;
		}

		if (left < 0 || arr[left] < arr[right]) {
			leftSmaller = true;
		} else {
			while (left >= 0) {
				arr[right++] = arr[left--];
			}
		}

		if (leftSmaller) {
			right = (n % 2 == 0) ? mid : mid + 1;
			left = mid - 1;

			int carry = 1;

			if (n % 2 != 0) {
				arr[mid] = arr[mid] + 1;
				carry = arr[mid] / 10;
				arr[mid] %= 10;
			}

			while (left >= 0) {
				arr[left] += carry;
				carry = arr[left] / 10;
				arr[left] %= 10;
				arr[right++] = arr[left--];
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i]);
		}
	}

	private static boolean all9s(int[] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 9)
				return false;
		}
		return true;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int t, n;
		String str;
		t = sc.nextInt();
		sc.nextLine();

		while (t > 0) {
			str = sc.nextLine();
			n = str.length();
			int[] intArray = new int[n];

			for (int i = 0; i < n; i++) {
				intArray[i] = (int) (str.charAt(i) - '0');
			}

			getNextPalindromeNumber(intArray, n);

			t--;
		}

		sc.close();
	}
}
