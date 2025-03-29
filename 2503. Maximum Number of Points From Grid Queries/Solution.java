import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	int[] parent;
	int[] size;

	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public int[] maxPoints(int[][] grid, int[] queries) {

		int k = queries.length;

		int[] result = new int[k];

		int[][] sortedQueries = new int[queries.length][2];

		for (int i = 0; i < k; i++) {
			sortedQueries[i][0] = queries[i];
			sortedQueries[i][1] = i;
		}

		Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

		int m = grid.length;
		int n = grid[0].length;

		List<int[]> cells = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				cells.add(new int[]{grid[i][j], i, j});
			}
		}

		cells.sort((a, b) -> Integer.compare(a[0], b[0]));

		parent = new int[m * n];
		size = new int[m * n];

		for ( int i = 0; i < m * n; i++ ) {
			parent[i] = i;
			size[i] = 1;
		}

		boolean[] visited = new boolean[m * n];
		int cellIndex = 0;

		for ( int[] query : sortedQueries ) {
			int qValue = query[0];
			int queryIndex = query[1];

			while ( cellIndex < cells.size() && cells.get(cellIndex)[0] < qValue ) {

				int[] cell = cells.get(cellIndex);
				int x = cell[1], y = cell[2];

				int idx = x * n + y;
				visited[idx] = true;

				for ( int i = 0; i < 4; i++ ) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					int nIdx = nx * n + ny;

					if ( nx >= 0 && nx < m && ny >= 0 && ny < n && visited[nIdx] ) {
						union(idx, nIdx);
					}
				}

				cellIndex++;
			}

			int startIdx = 0;
			result[queryIndex] = visited[startIdx] ? size[find(startIdx)] : 0;
		}

		return result;
	}

	public int find(int x) {
		if ( parent[x] != x ) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);

		if ( rootX == rootY ) return;

		if ( size[rootX] < size[rootY] ) {
			parent[rootX] = rootY;
			size[rootY] += size[rootX];
		} else {
			parent[rootY] = rootX;
			size[rootX] += size[rootY];
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] grid = {{1, 2, 3}, {2, 5, 7}, {3, 5, 1}};
		int[] queries = {5, 6, 2};

		int[] res = solution.maxPoints(grid, queries);

		Arrays.stream(res).forEach((x) -> {
			System.out.print(x + " ");
		});
	}
}
