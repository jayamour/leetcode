public class Solution {

	public static int longestCommonSubsequence(String text1, String text2) {

		String rowStr, colStr;

		if ( text1.length() >= text2.length() ) {
			rowStr = text1;	//	abcde
			colStr = text2;	//	ace
		} else {
			colStr = text1;
			rowStr = text2;
		}

		int [][] dp = new int[colStr.length() + 1][rowStr.length() + 1];

		rowStr = "*" + rowStr;
		colStr = "*" + colStr;

		char[] rowCh = rowStr.toCharArray();
		char[] colCh = colStr.toCharArray();

//		for ( int i = 0; i < rowCh.length; i++ ) {
//			System.out.print(rowCh[i] + " ");
//		}
//		System.out.println();

		/*
		  * a b c d e
		* 0 0 0 0 0 0
		a 0
		c 0
		e 0
		*/

		for ( int i = 1; i < colStr.length(); i++ ) {

			for ( int j = 1; j < rowStr.length(); j++ ) {

				if ( colCh[i] == rowCh[j] ) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

//		print(dp);

		return dp[colStr.length()-1][rowStr.length()-1];
	}

	static void print(int[][] arr) {

		for ( int i = 0; i < arr.length; i++ ) {

			for ( int j = 0; j < arr[i].length; j++ ) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int result = longestCommonSubsequence("abcde", "ace");
		System.out.println("result = " + result);
	}
}
