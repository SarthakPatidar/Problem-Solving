package leetCode;

import java.util.*;

/*
 * k = starting row index
 * n = ending row index
 * l = starting column index
 * m = ending column index
 */

public class SpiralMatrixPrint {
	public static void main(String[] args) {

		int n, m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		int arr[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int l = 0, k = 0;
		while (l < m && k < n) {
			for (int i = l; i < m; i++) {
				System.out.println(arr[k][i] + " ");
			}
			k++;

			for (int i = k; i < n; i++) {
				System.out.println(arr[i][m - 1] + " ");
			}
			m--;

			if (l < m) {
				for (int i = m - 1; i >= l; i--) {
					System.out.println(arr[n - 1][i]);
				}
				n--;
			}

			if (k < n) {
				for (int i = n - 1; i >= k; i--) {
					System.out.println(arr[i][l]);
				}
				l++;
			}
		}

		sc.close();
	}

}
