import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<List<Integer>> ans = new ArrayList<>();

		Arrays.sort(candidates);

		int limit = 0;

		for ( int i = 0; i < candidates.length; i++ ) {

			if ( candidates[i] > target ) {
				limit = i - 1;
				break;
			}
		}

		if ( limit == 0 ) {
			limit = candidates.length - 1;
		}

		int [] arr = Arrays.copyOf(candidates, limit + 1);

		for ( int i : arr ) {
			System.out.print(i + " ");
		}
		System.out.println();

		backtracking(0, arr, target, new ArrayList<>(), ans);

		return ans;
	}

	public void backtracking(int start, int[] arr, int target, List<Integer> list, List<List<Integer>> ans) {

		System.out.println("s: " + start + ", t: " + target);

		if ( target < 0 ) {
			return;
		}

		if ( target == 0 ) {
			ans.add(new ArrayList<>(list));
			return;
		}

		//	1,1,2,5,6,7
		//	2 2 2 2 2
		for ( int i = start; i < arr.length; i++ ) {

			if ( i > 1 ) {
				System.out.println("i: " + arr[i] + " == " + arr[i - 1]);
			} else {
				System.out.println("i: " + arr[i]);
			}

			System.out.println("start " + start + " vs " + i);
			if ( i > start && arr[i] == arr[i-1] ) {
				System.out.println("!!!!!!");
				continue;
			}

			System.out.println("here: " + i);

			list.add(arr[i]);
			backtracking(i + 1, arr, target - arr[i], list, ans);
			System.out.println(i + " end ~~~ ");
			list.remove(list.size()-1);
		}
	}

	public static void main(String[] args) {

//		int [] arr = {10,1,2,7,6,1,5};
		int [] arr = {1,2,2,3,5};
		int t = 8;

		Solution s = new Solution();
		System.out.println(s.combinationSum2(arr, t));
	}
}
