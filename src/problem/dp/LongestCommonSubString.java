package problem.dp;

public class LongestCommonSubString {

	public static void main(String[] args) {
		String s = "DEADBEEF";
		String t = "EATBEEF";
		System.out.println(getLongestCommonSubString(s, t));

	}

	private static int getLongestCommonSubString(String s, String t) {
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		int m = sArray.length;
		int n = tArray.length;
		int[][] D = new int[m][n];
		int max_val = -1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (sArray[i] == tArray[j]) {
					D[i][j] = 1 + D[i - 1][j - 1];
				} else {
					D[i][j] = 0;
				}
				max_val = Math.max(max_val, D[i][j]);
			}
		}
		return max_val;
	}

}
