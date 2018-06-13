package problem.dp;

/**
 * Given a rod of lenth n and price P[i] for i=1,2,3,....,n. Where P[i] is the
 * price of a rod of length i. Find the MAXIMUM total revenue you can make by
 * cutting and selling the rod. (Assume no cost for cutting the rod.)
 * ===============================================================
 * ||Rod of length i      | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10||
 * ||=====================|=======================================||
 * ||Price of i length rod| 1 | 5 | 8 | 9 | 10| 17| 17| 20| 24| 20||
 * ===============================================================
 * @author Suraj
 *
 */
public class CuttingRods {

	public static void main(String[] args) {
		int[] prices = {1,5,8,9,10};
		int rodLength = 5;
		System.out.println(getRevenueByRecursion(prices,rodLength));
		System.out.println(getRevenueByDP(prices,rodLength));
	}

	
	
	/**
	 * Recursive Solution: If I get max of left part and max of right part,
	 * then,their sum will maximize my revenue. So, lets say if i cut a piece of
	 * length 1, sell it and find optimal solution for rod of (n-1) length.
	 * Revenue(n) = P[1]+Revenue(n-1). Similarly, If I cut a piece of length 2,
	 * sell it and find optimal solution for rod of (n-2) length.Revenue(n) =
	 * P[2]+Revenue(n-2). Likewise,If I cut a piece of length (n-1), sell it and
	 * find optimal solution for rod of (1) length.Revenue(n) =
	 * P[n-1]+Revenue(1). And If i sell the whole rod of length n.Revenue(n) =
	 * P[n]+Revenue(0). 
	 * Hence, the best choice is: 
	 * R[n] = max(P[1]+Revenue(n-1),P[2]+Revenue(n-2).......,P[n-1]+Revenue(1),P[n])
	 */
	private static int getRevenueByRecursion(int[] prices, int rodLength) {
		// Base Case when rod length is 0.
		if(rodLength == 0) return 0;
		int max_value = -1;
		for(int i=0;i<rodLength;++i){
			int temp = prices[rodLength-i-1]+getRevenueByRecursion(prices, i);
			if(temp > max_value){
				max_value = temp;
			}
		}
		return max_value;
	}
	/**
	 * Problem with above approach: Say CR is cutting Rod
	 *                     CR(4)
	 *              /       /   \      \
	 *           CR(3)      CR(2) CR(1) CR(0)
	 *        /      \   \
	 *    CR(2)  CR(1) CR(0)
	 *    /   \
	 *  CR(1) CR(0)
	 *  There are so many repeated nodes/subtrees. We can use DP to use pre-computed values.               
	 */ 
	private static int getRevenueByDP(int[] prices, int rodLength) {
		int[] R = new int[rodLength + 1];// Array of rodLength size to store
											// results.
		// Base case initialization.
		R[0] = 0;
		for (int i = 1; i <= rodLength; ++i) {
			int max_val = -1;
			for (int j = 1; j <= i; ++j) {
				int temp = prices[j - 1] + R[i - j];
				if (temp > max_val) {
					max_val = temp;
				}
			}
			R[i] = max_val;
		}
		return R[rodLength];
	}
	

}
