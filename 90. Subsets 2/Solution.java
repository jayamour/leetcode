import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public List<List<Integer>> subsetsWithDup(int[] nums) {

		Arrays.sort(nums);

		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();

		ans.add(new ArrayList<>(list));

		for ( int i = 1; i < (1 << nums.length); i++ ) {

			list = new ArrayList<>();

			for ( int j = 0; j < nums.length; j++ ) {

				if ( (i & (1 << j)) != 0 ) {
					list.add(nums[j]);
				}
			}

			if ( !ans.contains(list) ) {
				ans.add(new ArrayList<>(list));
			}
		}

		return ans;
	}

	public static void main(String[] args) {

		int [] nums = {1,2,2};

		Solution s = new Solution();
		System.out.println(s.subsetsWithDup(nums));
	}
}