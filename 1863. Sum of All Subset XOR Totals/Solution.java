import java.util.ArrayList;
import java.util.List;

public class Solution {

	int sum = 0;

	public int subsetXORSum(int[] nums) {

		for ( int i = 0; i <= nums.length; i++ ) {
			combination(nums, new ArrayList<>(), 0, 0, nums.length, i);
		}

		return sum;
	}

	public void combination(int[] arr, List<Integer> selected, int xor, int start, int n, int r) {

		if ( selected.size() == r ) {
			sum += xor;
			return;
		}

		for ( int i = start; i < arr.length; i++ ) {
			selected.add(arr[i]);
			combination(arr, selected, xor ^ arr[i], i + 1, n, r);
			selected.removeLast();
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {5, 1, 6};
		System.out.println(solution.subsetXORSum(nums));
	}
}
