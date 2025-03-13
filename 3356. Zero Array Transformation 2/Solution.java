import java.util.Arrays;

public class Solution {

	public int minZeroArray(int[] nums, int[][] queries) {

		if ( Arrays.stream(nums).allMatch(x -> x == 0)) return 0;

		int low = 0, high = queries.length;

		if ( !isZero(high, nums, queries) ) return -1;

		while ( low < high ) {
			int mid = low + (high - low) / 2;

			//	if the number of mid is possible then [low, mid]
			if ( isZero(mid, nums, queries) ) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private static boolean isZero(int k, int[] nums, int[][] queries) {

		int N = nums.length;
		int[] diff = new int[N + 1];

		for ( int i = 0; i < k; i++ ) {

			int[] q = queries[i];

			int start = q[0];
			int end = q[1];
			int val = q[2];

			diff[start] += val;
			diff[end + 1] -= val;
		}

		int acc = 0;
		for ( int i = 0; i < N; i++ ) {
			acc += diff[i];

			if ( acc < nums[i] ) return false;
		}

		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

//		int[] nums = {2, 0, 2};
		int[] nums = {4, 3, 2, 1};
		int[][] queries = {{1, 3, 2}, {0, 2, 1}};
//		int[][] queries = {{0, 2, 1}, {0, 2, 1}, {1, 1, 3}};

		System.out.println(s.minZeroArray(nums, queries));
	}
}
