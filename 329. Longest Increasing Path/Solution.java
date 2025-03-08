public class Solution {

	int ROW;
	int COL;

	int [][] dp;

	public int longestIncreasingPath(int[][] matrix) {

		ROW = matrix.length;
		COL = matrix[0].length;

		dp = new int[ROW][COL];

		int answer = 0;

		for ( int i = 0; i < ROW; i++ ) {
			for ( int j = 0; j < COL; j++ ) {
				answer = Math.max(answer, dfs(i, j, -1, matrix));
			}
		}

//		print(matrix);
//		System.out.println("============");
//		print(dp);

		return answer;
	}

	public int dfs(int row, int col, int prev, int[][] matrix) {

		if ( row < 0 || col < 0 || row == ROW || col == COL || matrix[row][col] <= prev ) {
			return 0;
		}

		if ( dp[row][col] != 0 ) {
			return dp[row][col];
		}

		int result = 1;

		result = Math.max(result, 1 + dfs(row + 1, col, matrix[row][col], matrix));
		result = Math.max(result, 1 + dfs(row - 1, col, matrix[row][col], matrix));
		result = Math.max(result, 1 + dfs(row, col + 1, matrix[row][col], matrix));
		result = Math.max(result, 1 + dfs(row, col - 1, matrix[row][col], matrix));

		dp[row][col] = result;

		return dp[row][col];
	}

	private void print(int[][] arr) {

		for ( int i = 0 ; i < arr.length; i++ ) {
			for ( int j = 0; j < arr[i].length; j++ ) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int [][] arr = {{9,9,4},{6,6,8},{2,1,1}};

		Solution s = new Solution();
		System.out.println(s.longestIncreasingPath(arr));
	}
}
