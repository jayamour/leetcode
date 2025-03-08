import java.util.*;

public class Solution {

	public int minSubArrayLen(int target, int[] nums) {

		int start = 0, end = 0;

		int sum = 0;

		int min = Integer.MAX_VALUE;

		while ( start < nums.length && end < nums.length ) {
			//	          s
			//	0 1 2 3 4 5
			//	2 3 1 2 4 3
			//	          e
			sum += nums[end++];

			while ( sum >= target ) {
				int length = end - start;
				min = Math.min(min, length);
				sum -= nums[start++];
			}
		}

		if ( min == Integer.MAX_VALUE ) {
			return 0;
		}

		return min;
	}

	public static void main(String[] args) {

		int[] nums = {1,2,3,4,5};
		int target = 15;

		Solution s = new Solution();
		System.out.println(s.minSubArrayLen(target, nums));
	}
}
