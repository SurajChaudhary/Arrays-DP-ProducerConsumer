package problem.dp;

public class BuyAndSellStock {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int numberOfDays = 6;
		System.out.println(getMaxProfit(numberOfDays, prices));
		System.out.println(getMaxProfitRecursive(numberOfDays, prices));
		System.out.println(getMaxProfitWithDP(numberOfDays, prices));
		System.out.println(getMaxProfitWithOptimizedDP(numberOfDays, prices));

	}

	// Naive Solution. O(n2)
	private static int getMaxProfit(int n, int[] prices) {
		int max_val = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				max_val = Math.max(max_val, prices[j] - prices[i]);
			}
		}
		return max_val;
	}

	// Recursive Solution. O(n2)
	private static int getMaxProfitRecursive(int n, int[] prices) {
		// Base case
		if (n == 0)
			return 0;
		int max_val = getMaxProfitRecursive(n - 1, prices);
		for (int j = 1; j <= n; j++) {
			max_val = Math.max(max_val, prices[n - 1] - prices[j - 1]);
		}
		return max_val;
	}

	// Dynamic Programming Solution. O(n2)
	private static int getMaxProfitWithDP(int n, int[] prices) {
		int[] profit = new int[n];
		profit[0] = 0;
		for (int i = 1; i < n; i++) {
			profit[i] = profit[i - 1];
			for (int j = 0; j <= i; j++) {
				profit[i] = Math.max(profit[i], prices[i] - prices[j]);
			}
		}
		return profit[n - 1];
	}

	// Dynamic Programming Solution. O(n)
	private static int getMaxProfitWithOptimizedDP(int n, int[] prices) {
		int[] profit = new int[n];
		profit[0] = 0;
		int min_val = prices[0];
		for (int i = 1; i <= n - 1; i++) {
			min_val = Math.min(min_val, prices[i]);
			profit[i] = Math.max(profit[i - 1], prices[i] - min_val);
		}
		return profit[n - 1];
	}
}
