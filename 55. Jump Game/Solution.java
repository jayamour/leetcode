
public class Solution {

	public boolean canJump(int[] nums) {

		int dist = 0;
		int goal = nums.length - 1;

		//	3, 2, 1, 0, 4

		for ( int i = 0; i <= dist; i++ ) {

			dist = Math.max(dist, i + nums[i]);

			if ( dist >= goal ) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {

		Solution s = new Solution();
//		System.out.println(s.canJump(new int[]{3, 2, 1, 0, 4}));


//		System.out.println(s.canJump(new int[]{3, 2, 1, 0, 4}));

		System.out.println(s.canJump(new int[]{2, 3, 1, 0, 2, 2, 0, 0}));
		//	0, 1, 2, 3, 4, 5, 6, 7
		//	2, 3, 1, 0, 2, 1, 0, 0
	}
}
