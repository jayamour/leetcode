import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int[] pivotArray(int[] nums, int pivot) {

		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		int pivotCnt = 0;

		for ( int i = 0; i < nums.length; i++ ) {
			if ( nums[i] < pivot ) {
				left.add(nums[i]);
			} else if ( nums[i] > pivot ) {
				right.add(nums[i]);
			} else {
				pivotCnt++;
			}
		}

		List<Integer> ans = new ArrayList<>();
		ans.addAll(left);

		for ( int i = 0; i < pivotCnt; i++ ) {
			ans.add(pivot);
		}

		ans.addAll(right);

		return ans.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		int[] nums = {9, 12, 5, 10, 14, 3, 10};
		int pivot = 10;

//		int[] nums = {-3, 4, 3, 2};
//		int pivot = 2;

		int[] res = s.pivotArray(nums, pivot);

		for ( int i = 0; i < res.length; i++ ) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
	}
}
