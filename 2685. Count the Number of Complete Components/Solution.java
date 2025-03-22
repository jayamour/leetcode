import java.util.*;

public class Solution {

	int[] parent;
	int[] rank;

	public int countCompleteComponents(int n, int[][] edges) {

		parent = new int[n];
		rank = new int[n];

		for ( int i = 0; i < n; i++ ) {
			parent[i] = i;
		}

		for ( int[] edge : edges ) {
			int u = edge[0];
			int v = edge[1];
			union(u, v);
		}

		Map<Integer, Integer> compNodes = new HashMap<>();

		for ( int i = 0; i < n; i++ ) {
			int root = find(i);
			compNodes.put(root, compNodes.getOrDefault(root, 0) + 1);
		}

		Map<Integer, Integer> compEdges = new HashMap<>();

		for ( int[] edge : edges ) {
			int u = edge[0];
			int root = find(u);
			compEdges.put(root, compEdges.getOrDefault(root, 0) + 1);
		}

		int count = 0;

		for ( int root : compNodes.keySet() ) {

			int node = compNodes.get(root);

			if ( node == 1 ) {
				count++;
			} else {
				if ( compEdges.get(root) == node * (node - 1) / 2 ) {
					count++;
				}
			}
		}

		return count;
	}

	public void union(int x, int y) {
		int px = find(x);
		int py = find(y);

		if ( px == py ) {
			return;
		}

		if ( rank[px] > rank[py] ) {
			parent[py] = px;
		} else if ( rank[px] < rank[py] ) {
			parent[px] = py;
		} else {
			parent[py] = px;
			rank[px]++;
		}
	}

	public int find(int x) {

		if ( parent[x] != x ) {
			parent[x] = find(parent[x]);
		}

		return parent[x];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int n = 4;
		int[][] edges = {{2, 0}, {3, 1}, {3, 2}};

		System.out.println(solution.countCompleteComponents(n, edges));
	}
}
