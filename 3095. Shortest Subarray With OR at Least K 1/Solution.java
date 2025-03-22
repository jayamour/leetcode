public class Solution {

	public int minimumSubarrayLength(int[] nums, int k) {
		int N = nums.length;
		int ans = Integer.MAX_VALUE;

		for ( int windowSize = 1; windowSize <= N; windowSize++ ) {

			for ( int i = 0; i <= N - windowSize; i++ ) {

				int res = 0;

				for ( int j = i; j < i + windowSize; j++ ) {
					res = res | nums[j];
				}

				if ( res >= k ) {
					ans = Math.min(ans, windowSize);
					break;
				}
			}
		}

		return ans == Integer.MAX_VALUE ? -1 : ans;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {1, 2};
		int k = 0;
		System.out.println(s.minimumSubarrayLength(nums, k));
	}
}
