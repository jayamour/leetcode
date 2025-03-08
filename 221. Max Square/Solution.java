public class Solution {

	public int maximalSquare(char[][] matrix) {

		int[][] dp = new int[matrix.length][matrix[0].length];

		int maxArea = 0;

		for ( int i = 0; i < matrix.length; i++ ) {

			if ( matrix[i][0] == '1' ) {
				dp[i][0] = 1;
				maxArea = 1;
			}
		}

		for ( int j = 0; j < matrix[0].length; j++ ) {

			if ( matrix[0][j] == '1' ) {
				dp[0][j] = 1;
				maxArea = 1;
			}
		}

		for ( int i = 1; i < matrix.length; i++ ) {

			for ( int j = 1; j < matrix[0].length; j++ ) {

				if ( matrix[i][j] == '0' ) {
					dp[i][j] = 0;
				} else {

					if ( matrix[i-1][j-1] == '0' || matrix[i-1][j] == '0' || matrix[i][j-1] == '0' ) {
						dp[i][j] = 1;
						maxArea = Math.max(maxArea, dp[i][j]);
					} else {
						dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
						maxArea = Math.max(maxArea, dp[i][j]);
					}
				}
			}
		}

		print(dp);

		return maxArea * maxArea;
	}

	public void print(int [][] arr) {

		for ( int i = 0; i < arr.length; i++ ) {
			for ( int j = 0; j < arr[0].length; j++ ) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

//		char[][] arr = {
//				{'1','0','1','0','0'},
//				{'1','0','1','1','1'},
//				{'1','1','1','1','1'},
//				{'1','0','1','1','1'},
//				{'0','1','0','1','0'}
//		};

//		char[][] arr = {
//				{'0', '1'},
//				{'1', '0'}
//		};

		char[][] arr = {
				{'1','1','1','1','0'},
				{'1','1','1','1','0'},
				{'1','1','1','1','1'},
				{'1','1','1','1','1'},
				{'0','0','1','1','1'}
		};

		Solution s = new Solution();
		System.out.println(s.maximalSquare(arr));
	}
}