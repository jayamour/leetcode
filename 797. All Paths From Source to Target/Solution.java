import java.util.*;

public class Solution {

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

		List<List<Integer>> ans = new ArrayList<>();
		Deque<List<Integer>> stack = new ArrayDeque<>();

		stack.push(new ArrayList<>(List.of(0)));

		while ( !stack.isEmpty() ) {
			//	Stack에서 경로를 꺼냄
			List<Integer> path = stack.pop();
			int last = path.get(path.size() - 1);

			if ( last == graph.length - 1 ) {
				ans.add(new ArrayList<>(path));
			} else {
				for ( int i : graph[last] ) {
					path.add(i);
					stack.push(new ArrayList<>(path));
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {

		Solution s = new Solution();
		s.allPathsSourceTarget(new int[][] { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} });
	}
}
