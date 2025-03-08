public class Solution {

	public int change(int amount, int[] coins) {

		/*
		int [][] dp = new int[coins.length + 1][amount + 1];

		for ( int i = 0; i < coins.length + 1; i++ ) {
			dp[i][0] = 1;
		}

		dp[0][0] = 1;

		for ( int j = 1; j < amount + 1; j++ ) {
			dp[0][j] = 0;
		}

		for ( int i = 1; i < coins.length + 1; i++ ) {

			for ( int j = 1; j < amount + 1; j++ ) {

				if ( (j - coins[i-1]) < 0 ) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
				}
			}
		}
		*/

//		print(dp);

//		return dp[coins.length][amount];

		int [] dp = new int[amount + 1];
		dp[0] = 1;

		for ( int i = 0; i < coins.length; i++ ) {

			//	2 ~ 5
			for ( int j = coins[i]; j < dp.length; j++ ) {
				System.out.println("dp[" + j + "] = " + dp[j] + ", dp[" + j + " - coins[" + i + "] = " + dp[j-coins[i]]);
				dp[j] = dp[j] + dp[j-coins[i]];
			}

			print(dp);
		}

		return dp[amount];
	}

	public void print(int [] arr) {

		for ( int i = 0; i < arr.length; i++ ) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public void print(int[][] arr) {

		for ( int i = 0; i < arr.length; i++ ) {
			for ( int j = 0; j < arr[0].length; j++ ) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int amount = 5;
		int[] coins = {1,2,5};

		Solution s = new Solution();
		System.out.println(s.change(amount, coins));
	}
}
