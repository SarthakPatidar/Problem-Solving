package codechef.saturnalia;

import java.util.*;

public class ChefLovesChocolate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		int n, m;

		while (t > 0) {
			n = sc.nextInt();
			m = sc.nextInt();

			int chocolates[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					chocolates[i][j] = sc.nextInt();
				}
			}

			int dp[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (i == 0 && j == 0)
						dp[i][j] = chocolates[i][j];
					else if (i == 0)
						dp[i][j] = chocolates[i][j] + dp[i][j-1];
					else if (j == 0)
						dp[i][j] = chocolates[i][j] + dp[i-1][j];
					else
						dp[i][j] = chocolates[i][j] + Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
				}
			}

			System.out.println(dp[n - 1][m - 1]);

			t--;
		}
		sc.close();
	}
}
