import java.util.*;

public class Solution {

	public int maximalNetworkRank(int n, int[][] roads) {

		Map<Integer, List<Integer>> graph = new HashMap<>();

		int[] degree = new int[n];

		for ( int i = 0; i < roads.length; i++ ) {

			degree[roads[i][0]]++;
			degree[roads[i][1]]++;

			graph.putIfAbsent(roads[i][0], new ArrayList<>());
			graph.putIfAbsent(roads[i][1], new ArrayList<>());
			graph.get(roads[i][0]).add(roads[i][1]);
			graph.get(roads[i][1]).add(roads[i][0]);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int sum = 0;

		for ( int i = 0; i < (n - 1); i++ ) {

			for ( int j = (i + 1); j < n; j++ ) {
				sum = degree[i] + degree[j];

				if ( graph.get(i) != null && graph.get(i).contains(j) ) {
					sum--;
				}
				pq.add(sum);
			}
		}

		return pq.poll();
	}

	public static void main(String[] args) {
		int[][] roads = {{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}};
		Solution s = new Solution();
		System.out.println(s.maximalNetworkRank(5, roads));
	}
}
