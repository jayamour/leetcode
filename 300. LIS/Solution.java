import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	public int lengthOfLIS(int[] nums) {

		int [] lis = new int[nums.length];
		Arrays.fill(lis, 1);

		lis[nums.length-1] = 1;

		int max = 1;

		//	1, 2, 4, 3
		for ( int i = nums.length-1; i >= 0; i-- ) {

			for ( int j = (i+1); j < nums.length; j++ ) {

				//	1,3,6,7,9,4,10,5,6
				if ( nums[i] < nums[j] ) {
					lis[i] = Math.max(lis[i], 1 + lis[j]);
					max = Math.max(lis[i], max);
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {

//		int [] nums = {10,9,2,5,3,7,101,18};
		int [] nums = {1,3,6,7,9,4,10,5,6};

		Solution s = new Solution();
		System.out.println(s.lengthOfLIS(nums));
	}
}
