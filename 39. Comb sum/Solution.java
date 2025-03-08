import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	List<List<Integer>> result;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		result = new ArrayList<>();

		dfs(0, target, 0, candidates, new ArrayList<>());

		return result;
	}

	public void dfs(int start, int target, int total, int [] nums, List<Integer> list) {

		if ( total > target ) {
			System.out.println("total: " + total);
			return;
		}

		if ( total == target ) {
			result.add(new ArrayList<>(list));
			return;
		}

		for ( int i = start; i < nums.length; i++ ) {
			list.add(nums[i]);
			total += nums[i];

			System.out.println(i + ", nums[" + i + "]: " + nums[i]);
			dfs(i, target, total, nums, list);
			int last = list.get(list.size()-1);
			total -= last;
			list.remove(list.size()-1);
		}

		/*
			2
				2 2
					2 2 2
						2 2 2 2 o
					2 2 3
						2 2 3 2	x
					2 2 5	x
				2 3
					2 3 2
						2 3 2 2 x
					2 3 3	o
					2 3 5	x
				2 5
					2 5 2	x
			3
				3 2
					3 2 2
						3 2 2 2	x
					3 2 3	o
				3 3
					3 3 2	o
				3 5	o
		 */
	}

	public void print(int[] dp) {

		for ( int i : dp ) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int[] candidate = {2, 3, 5};
		int target = 8;

		Solution s = new Solution();
		System.out.println(s.combinationSum(candidate, target));
	}
}
