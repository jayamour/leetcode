import java.util.*;

public class DfsSolution {

	Map<Integer, List<Integer>> graph;

	public int countCompleteComponents(int n, int[][] edges) {

		graph = new HashMap<>();
		boolean[] visited = new boolean[n];

		for ( int[] edge : edges ) {
			int u = edge[0];
			int v = edge[1];

			graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
			graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
		}

		int count = 0;

		for ( int i = 0; i < n; i++ ) {
			if ( !visited[i] ) {

				List<Integer> compNodes = new ArrayList<>();
				int[] edgesCount = new int[1];

				dfs(i, visited, compNodes, edgesCount);

				int node = compNodes.size();
				int edge = edgesCount[0] / 2;

				if ( node == 1 || edge == node * (node - 1) / 2 ) {
					count++;
				}
			}
		}

		return count;
	}

	private void dfs(int i, boolean[] visited, List<Integer> compNodes, int[] edgesCount) {

		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(i);
		visited[i] = true;

		while ( !stack.isEmpty() ) {

			int node = stack.pop();

			compNodes.add(node);

			edgesCount[0] += graph.getOrDefault(node, new ArrayList<>()).size();

			for ( int neighbor : graph.getOrDefault(node, new ArrayList<>()) ) {

				if ( !visited[neighbor] ) {
					stack.push(neighbor);
					visited[neighbor] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		DfsSolution solution = new DfsSolution();

		int n = 5;
		int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};

		System.out.println(solution.countCompleteComponents(n, edges));
	}
}
