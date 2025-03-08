import java.util.*;

public class Solution {

	int minHeight = Integer.MAX_VALUE;

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {

		if ( n == 1 ) {
			return List.of(0);
		}

		Map<Integer, List<Integer>> graph = new HashMap<>();

//		int[] degree = new int[n];

		for ( int i = 0; i < edges.length; i++ ) {
//			degree[edges[i][0]]++;
//			degree[edges[i][1]]++;

			graph.putIfAbsent(edges[i][0], new ArrayList<>());
			graph.putIfAbsent(edges[i][1], new ArrayList<>());

			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}

		Queue<Integer> leaves = new LinkedList<>();

		for ( int i = 0; i < n; i++ ) {
			if ( graph.get(i).size() == 1 ) {
				leaves.offer(i);
			}
		}

		while ( n > 2 ) {

			int size = leaves.size();
			n -= size;

			for ( int i = 0; i < size; i++ ) {

				int leaf = leaves.poll();

				if ( graph.containsKey(leaf) ) {

					for ( int to : graph.get(leaf) ) {

						graph.get(to).remove(Integer.valueOf(leaf));

						if ( graph.get(to).size() == 1 ) {
							leaves.offer(to);
						}
					}
					graph.remove(leaf);
				}
			}
		}

		return new ArrayList<>(leaves);
	}

	private void bfs(int i, boolean[] visited, Map<Integer, List<Integer>> graph, List<Integer> ans) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(i);
		visited[i] = true;

		int height = -1;

		while ( !queue.isEmpty() ) {

			int size = queue.size();

			for ( int j = 0; j < size; j++ ) {

				int node = queue.poll();

				List<Integer> neighbors = graph.get(node);

				for ( int k = 0; k < neighbors.size(); k++ ) {

					int neighbor = neighbors.get(k);

					if ( !visited[neighbor] ) {
						visited[neighbor] = true;
						queue.add(neighbor);
					}
				}
			}

			height++;
		}

		if ( height < minHeight ) {
			minHeight = height;
			ans.clear();
			ans.add(i);
		} else if ( height == minHeight ) {
			ans.add(i);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
//		s.findMinHeightTrees(4, new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } });
		System.out.println(s.findMinHeightTrees(6, new int[][] { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4} }));
	}
}
