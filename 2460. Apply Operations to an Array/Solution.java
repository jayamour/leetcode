import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public int[] applyOperations(int[] nums) {

		for ( int i = 0; i < nums.length - 1; i++ ) {

			if ( nums[i] == 0 ) {
				continue;
			}

			if ( nums[i] == nums[i + 1] ) {
				nums[i] = nums[i] + nums[i + 1];
				nums[i + 1] = 0;
			}
		}

		int cnt = 0;
		List<Integer> ans = new ArrayList<>();

		for ( int i = 0; i < nums.length; i++ ) {

			if ( nums[i] != 0 ) {
				ans.add(nums[i]);
			} else {
				cnt++;
			}
		}

		for ( int i = 0; i < cnt; i++ ) {
			ans.add(0);
		}

		return ans.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
	}
}
