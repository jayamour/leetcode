import java.util.*;

public class Solution {

	Map<Integer, List<Integer>> graph;

	public int reachableNodes(int n, int[][] edges, int[] restricted) {

		graph = new HashMap<>();

		Set<Integer> set = new HashSet<>();
		for ( int i : restricted ) {
			set.add(i);
		}

		boolean[] visited = new boolean[n];

		for ( int[] edge : edges ) {
			if ( !set.contains(edge[0]) && !set.contains(edge[1]) ) {
				graph.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
				graph.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
			}
		}

		int ans = dfs(0, visited);

		return ans;
	}

	private int dfs(int i, boolean[] visited) {

		int count = 0;

		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(i);
		visited[i] = true;

		while ( !stack.isEmpty() ) {

			i = stack.pop();

			count++;

			if ( graph.containsKey(i) ) {
				for ( int j : graph.get(i) ) {
					if ( visited[j] ) {
						continue;
					}
					stack.push(j);
					visited[j] = true;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		int n = 7;
		int[][] edges = {{0, 1}, {0, 2}, {0, 5}, {0, 4}, {3, 2}, {6, 5}};
		int[] restricted = {4, 2, 1};

		System.out.println(s.reachableNodes(n, edges, restricted));
	}
}
