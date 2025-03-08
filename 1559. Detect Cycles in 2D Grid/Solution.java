import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};

	int m, n;

	public boolean containsCycle(char[][] grid) {
		m = grid.length;
		n = grid[0].length;

		// 2차원 방문 배열 사용
		boolean[][] visited = new boolean[m][n];

		for ( int i = 0; i < m; i++ ) {
			for ( int j = 0; j < n; j++ ) {
				if ( !visited[i][j] ) {
					if ( bfs(i, j, grid, visited) ) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * BFS 탐색 시, 현재 노드와 함께 부모 노드의 좌표를 저장합니다.
	 * 부모 노드와 연결된 간선은 사이클로 판단하지 않도록 합니다.
	 */
	private boolean bfs(int i, int j, char[][] grid, boolean[][] visited) {
		char ch = grid[i][j];
		Queue<int[]> queue = new LinkedList<>();
		// 각 원소는 {현재 x, 현재 y, 부모 x, 부모 y}
		// 시작 노드는 부모가 없으므로 (-1, -1)로 초기화
		queue.add(new int[]{i, j, -1, -1});
		visited[i][j] = true;

		while ( !queue.isEmpty() ) {
			int[] p = queue.poll();
			int x = p[0], y = p[1], px = p[2], py = p[3];

			for ( int k = 0; k < 4; k++ ) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if ( nx < 0 || nx >= m || ny < 0 || ny >= n ) continue;
				if ( grid[nx][ny] != ch ) continue;
				// 바로 이전(부모) 노드라면 건너뜁니다.
				if ( nx == px && ny == py ) continue;
				if ( visited[nx][ny] ) {
					// 방문한 적이 있고, 부모가 아닌 경우 사이클이 존재함
					return true;
				}
				visited[nx][ny] = true;
				queue.add(new int[]{nx, ny, x, y});
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		char[][] grid = {{'a', 'a', 'a', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'b', 'b', 'a'}, {'a', 'a', 'a', 'a'}};
		System.out.println(s.containsCycle(grid));
	}
}
