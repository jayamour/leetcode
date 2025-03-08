public class Solution {

	public int maxCoins(int[] nums) {

		int [] arr = new int[nums.length + 2];

		for ( int i = 1; i < nums.length + 1; i++ ) {
			arr[i] = nums[i-1];
		}

		arr[0] = 1;
		arr[arr.length - 1] = 1;

		int[][] dp = new int[nums.length + 1][nums.length + 1];

		for ( int x : arr ) {
			System.out.print(x + " ");
		}
		System.out.println();

		return dfs(1, nums.length, arr, dp);
	}

	public int dfs(int l, int r, int[] arr, int[][] dp) {


		if ( l > r ) {
			return 0;
		}

		if ( dp[l][r] != 0 ) {
			return dp[l][r];
		}

		dp[l][r] = 0;

		int coins = 0;

		for ( int i = l; i <= r; i++ ) {
			coins = arr[l - 1] * arr[i] * arr[r + 1];
			coins += dfs(l, i - 1, arr, dp) + dfs(i + 1, r, arr, dp);
			dp[l][r] = Math.max(coins, dp[l][r]);
		}

		return dp[l][r];
	}

	public static void main(String[] args) {

		int [] nums = {3,1,5,8};

		Solution s = new Solution();
		System.out.println(s.maxCoins(nums));
	}
}
