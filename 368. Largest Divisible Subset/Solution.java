import java.util.*;

public class Solution {

	public List<Integer> largestDivisibleSubset(int[] nums) {

		Arrays.sort(nums);

		int n = nums.length;
		int[] dp = new int[n];
		int[] prev = new int[n];

		Arrays.fill(dp, 1);
		Arrays.fill(prev, -1);

		int maxIndex = 0;

		for ( int i = 0; i < n; i++ ) {
			for ( int j = 0; j < i; j++ ) {
				if ( nums[i] % nums[j] == 0 ) {
					if ( dp[j] + 1 > dp[i] ) {
						dp[i] = dp[j] + 1;
						prev[i] = j;
					}
				}
			}

			if ( dp[i] > dp[maxIndex] ) {
				maxIndex = i;
			}
		}

		List<Integer> ans = new ArrayList<>();

		while ( maxIndex != -1 ) {
			ans.add(nums[maxIndex]);
			maxIndex = prev[maxIndex];
		}

		Collections.reverse(ans);

		return ans;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[] nums = {1, 2, 4, 5, 15, 45};

		System.out.println(solution.largestDivisibleSubset(nums));
	}
}
