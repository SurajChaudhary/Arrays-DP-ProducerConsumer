package problem.dp;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s = "ABACBDAB";
		String t = "BADCABA";
		
		System.out.println(getLongestCommonSubSequence(s,t));

	}

	private static int getLongestCommonSubSequence(String s, String t) {
		char [] sArray = s.toCharArray();
		char [] tArray = t.toCharArray();
		int m = sArray.length;
		int n = tArray.length;
		int [][] C = new int[m+1][n+1];
		
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(sArray[i-1] == tArray[j-1]){
					C[i][j] = C[i-1][j-1]+1;
				}else{
					C[i][j] = Math.max(C[i-1][j],C[i][j-1]);
				}
			}
		}
		return C[m][n];
	}

}
