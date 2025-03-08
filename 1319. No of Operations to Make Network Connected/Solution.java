import java.util.*;

public class Solution {

	public int makeConnected(int n, int[][] connections) {

		Map<Integer, Set<Integer>> map = new HashMap<>();

		if ( connections.length < n - 1 ) {
			return -1;
		}

		for ( int[] con : connections ) {

			if ( !map.containsKey(con[0]) ) {
				map.put(con[0], new HashSet<>());
			}
			map.get(con[0]).add(con[1]);

			if ( !map.containsKey(con[1]) ) {
				map.put(con[1], new HashSet<>());
			}
			map.get(con[1]).add(con[0]);
		}

		boolean[] visited = new boolean[n];

		int groupCnt = 0;

		for ( int i = 0; i < n; i++ ) {

			if ( !visited[i] ) {
				dfs(i, map, visited);
				groupCnt++;
			}
		}

		int needCons = groupCnt - 1;

		return needCons;
	}

	private void dfs(int i, Map<Integer, Set<Integer>> map, boolean[] visited) {

		//	dfs => stack
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(i);
		visited[i] = true;

		while ( !stack.isEmpty() ) {

			int cur = stack.pop();

			if ( map.containsKey(cur) ) {

				for ( int next : map.get(cur) ) {

					if ( !visited[next] ) {
						stack.push(next);
						visited[next] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.makeConnected(6, new int[][]{{0, 1}, {1, 2}, {1, 3}, {0, 2}, {0, 3}}));
	}
}
