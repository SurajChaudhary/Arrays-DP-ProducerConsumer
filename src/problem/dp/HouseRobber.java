package problem.dp;

public class HouseRobber {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(robHouse(5, nums));
		System.out.println(robHouseWithDP(5, nums));
		System.out.println(robHouseWithDPTwo(5, nums));

	}

	// Recursive solution
	private static int robHouse(int i, int[] nums) {
		if (i == 0)
			return 0;// When no house to rob.
		if (i == 1)
			return nums[0];// Only one house to rob.
		if (i == 2)
			return Math.max(nums[0], nums[1]);// When only 2 houses to rob.
		int max_val = -1;// initialize max value to -1.
		max_val = Math.max(max_val, robHouse(i - 1, nums));// When you don't
															// steal from house
															// i. Then you steal
															// fron house i-1.
		// If you steal from house i, then you can't steal from i-1 and can
		// start stealing from i-2.
		for (int j = i - 2; j >= 0; --j) {
			max_val = Math.max(max_val, robHouse(j, nums) + nums[i - 1]);
		}
		return max_val;
	}

	// Dynamic Programming solution O(n2).
	private static int robHouseWithDP(int n, int[] nums) {
		int[] sum = new int[n];
		sum[0] = nums[0];
		sum[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < n; i++) {
			sum[i] = sum[i - 1];

			for (int j = i - 2; j >= 0; --j) {
				sum[i] = Math.max(sum[i], sum[j] + nums[i]);
			}
		}
		return sum[n - 1];
	}

	// Dynamic Programming solution Two O(n).
	private static int robHouseWithDPTwo(int n, int[] nums) {
		int[] sum = new int[n];
		sum[0] = nums[0];
		sum[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < n; i++) {
			sum[i] = Math.max(sum[i - 1], sum[i - 2] + nums[i]);
		}
		return sum[n - 1];
	}

}
