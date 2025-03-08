public class Solution {

	public int rob(int[] nums) {

		int rob1 = 0, rob2 = 0;
		int temp;

		for ( int i = 0; i < nums.length; i++ ) {

			temp = Math.max(rob1 + nums[i], rob2);

			rob1 = rob2;
			rob2 = temp;
		}

		return rob2;
	}

	public static void main(String[] args) {

		int [] nums = {5,3,1,3,2,7};

		Solution s = new Solution();
		System.out.println(s.rob(nums));
	}
}
