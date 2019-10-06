package optimization.maxProfitBuySell;

import java.util.*;

/*
 * Input:   price[] = {10, 22, 5, 75, 65, 80}
 * Output:  87
 * Explaination: Trader earns 87 as sum of 12 and 75
 *               Buy at price 10, sell at 22, buy at 5 and sell at 80
 */

/*
 * 1) Create a table profit[0..n-1] and initialize all values in it 0.
 * 2) Traverse price[] from right to left and update profit[i] such that profit[i] stores maximum profit achievable from one transaction in subarray price[i..n-1]
 * 3) Traverse price[] from left to right and update profit[i] such that profit[i] stores maximum profit such that profit[i] contains maximum achievable profit from two transactions in subarray price[0..i].
 * 4) Return profit[n-1]
 */
public class MaxProfit {
	public static void main(String args[]) {

		int n;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();

		int price[] = new int[n];
		for (int i = 0; i < n; i++) {
			price[i] = s.nextInt();
		}

		int profit[] = new int[n];
		for (int i = 0; i < n; i++) {
			profit[i] = 0;
		}

		int max_price = price[n - 1];
		for (int i = n - 2; i >= 0; i--) {

			if (max_price < price[i])
				max_price = price[i];

			profit[i] = Math.max(profit[i + 1], max_price - price[i]);
		}

		int min_price = price[0];
		for (int i = 1; i < n; i++) {

			if (min_price > price[i])
				min_price = price[i];

			profit[i] = Math.max(profit[i - 1], profit[i] + (price[i] - min_price));
		}

		System.out.println(profit[n - 1]);
		s.close();

	}
}
