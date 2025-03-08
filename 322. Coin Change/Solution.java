import java.util.Arrays;

public class Solution {

	public int coinChange(int[] coins, int amount) {

		//	0 ~ amount
		int [] dp = new int[amount + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		//	2, 3, 7
		for ( int i = 1; i < (amount + 1); i++ ) {

//			dp[i] = dp.length;

			for ( int j = 0; j < coins.length; j++ ) {

				//	3 >= 2
				if ( i >= coins[j] && dp[i-coins[j]] != Integer.MAX_VALUE ) {
					dp[i] = Math.min(1 + dp[i-coins[j]], dp[i]);
				}
			}
		}

		if ( dp[amount] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return dp[amount];
		}
	}

	public void print(int[] dp) {
		for ( int i : dp ) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public int coinChange2(int[] coins, int amount) {

		int [][] arr = new int[coins.length][amount+2];

		Arrays.fill(arr[0], amount + 1);

		for ( int i = 0; i < arr.length; i++  ) {

			for ( int j = 0; j < amount+1; j++ ) {

				if ( j == 0 ) {
					arr[i][j] = 0;
					System.out.print(arr[i][j] + " ");
					continue;
				}

				if ( j >=coins[i] ) {

					System.out.println("j: " + j + ", coins["+ i + "]: " + coins[i]);

					if ( i == 0 ) {
						arr[i][j] = arr[i][j - coins[i]] + 1;
					} else {
						arr[i][j] = Math.min(arr[i][j - coins[i]] + 1, arr[i-1][j]);
					}
				} else {
					if ( i == 0 ) {
						arr[i][j] = 0;
					} else {
						arr[i][j] = arr[i - 1][j];
					}
				}
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		return arr[coins.length-1][amount] > amount ? -1 : arr[coins.length-1][amount];
	}

	public static void main(String[] args) {

//		int[] coins = {474,83,404,3};
		int[] coins = {2,5,10,1};
		int amt = 27;

		Solution s = new Solution();
		System.out.println(s.coinChange(coins, amt));
	}
}
