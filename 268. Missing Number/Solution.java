import java.util.Arrays;

public class Solution {

	public int missingNumber(int[] nums) {

		int sum = Arrays.stream(nums).sum();
		/*
		sum of 1 ~ n: n x (n + 1) / 2
		 */

		int n = nums.length;

		return n * (n + 1) / 2 - sum;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {9,6,4,2,3,5,7,0,1};
		System.out.println(solution.missingNumber(nums));
	}
}
