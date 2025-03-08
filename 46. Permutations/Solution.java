import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<Integer> list;

	List<List<Integer>> answerList = new ArrayList<>();

	public List<List<Integer>> permute(int[] nums) {

		if ( nums.length == 1 ) {
			Integer i = nums[0];
			List<Integer> list = new ArrayList<>();
			list.add(i);

			answerList = new ArrayList<>();
			answerList.add(list);

			return answerList;
		}

		boolean[] visited = new boolean[nums.length];
		int[] perm = new int[nums.length];

		dfs(0, nums, visited, perm, 0);

		return answerList;
	}

	public void dfs(int i, int[] nums, boolean [] visited, int[] perm, int level) {

		if ( level == nums.length ) {

			printBoolean(visited);

			list = new ArrayList<>();

			for ( int x : perm ) {
				list.add(x);
			}

			answerList.add(list);

			System.out.println("*** 여기서 종료 ***\n");
			return;
		}

		for ( int k = 0; k < nums.length; k++ ) {

			if ( visited[k] ) {
				continue;
			}


			printBoolean(visited);

			visited[k] = true;

			System.out.println("===> " + nums[k]);

			perm[level] = nums[k];

			System.out.println("before i: " + i + ", k: " + k + ", lv.: " + level);

			dfs(k, nums, visited, perm, level + 1);

			System.out.println("after i: " + i + ", k: " + k + ", lv.: " + level);

			printBoolean(visited);
			visited[k] = false;
		}
	}

	public void printBoolean(boolean[] visited) {

		for ( boolean b : visited ) {
			System.out.print(b + " ");
		}
		System.out.println();
	}

	void print(int[] nums) {

		for ( int i : nums ) {
			System.out.print("  " + i + "\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int [] nums = {1,2,3};

		Solution s = new Solution();
		System.out.println(s.permute(nums));
	}
}
