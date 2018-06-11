package problem.dp;

/**
 * You can climb either 1 or 2 stairs with one step. 
 * How many different ways can you climb n stairs?
 * 
 * @author Suraj
 *
 */
public class StairsClimbingProblem {

	public static void main(String[] args) {
		int stairCount = 5;
		System.out.println("Ways by recursion: " + getNumberOfWaysToClimbStais(stairCount));
		System.out.println("Ways by DP: " + getNumberOfWaysToClimbStaisUsingDP(stairCount));

	}

	// Naive approach using recursion
	private static int getNumberOfWaysToClimbStais(int stairCount) {
		// Base Cases
		if (stairCount == 1)
			return 1;
		if (stairCount == 2)
			return 2;
		return getNumberOfWaysToClimbStais(stairCount - 1) + getNumberOfWaysToClimbStais(stairCount - 2);
	}

	// Dynamic Programming approach.
	private static int getNumberOfWaysToClimbStaisUsingDP(int stairCount) {
		int[] dataCache = new int[stairCount + 1];
		dataCache[1] = 1;
		dataCache[2] = 2;
		for (int index = 3; index <= stairCount; index++) {
			dataCache[index] = dataCache[index - 1] + dataCache[index - 2];
		}
		return dataCache[stairCount];
	}

}
