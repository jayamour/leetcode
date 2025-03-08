import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	private static int[] dx = {1, 1, 1, 0, -1, -1, -1, 0};
	private static int[] dy = {1, 0, -1, -1, -1, 0, 1, 1};

	public int shortestPathBinaryMatrix(int[][] grid) {

		int ans = bfs(0, 0, grid);

		return ans;
	}

	public int bfs(int x, int y, int[][] grid) {

		int n = grid.length;

		// Check if start or end is blocked
		if (grid[0][0] != 0 || grid[n-1][n-1] != 0) {
			return -1;
		}

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{x, y, 1});

		while( !q.isEmpty() ) {

			int[] cur = q.poll();

			x = cur[0];
			y = cur[1];
			int steps = cur[2];

//				System.out.println( x + " " + y );

			if ( x == n - 1 && y == n - 1 ) {
				return steps;
			}

			for ( int k = 0; k < 8; k++ ) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if ( isValid(nx, ny, n) && grid[nx][ny] == 0 ) {
					grid[nx][ny] = -1;
					q.offer(new int[]{nx, ny, steps + 1});
				}
			}
		}

		return -1;
	}

	private boolean isValid(int x, int y, int n) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void main(String[] args) {

		Solution s = new Solution();
		System.out.println(s.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
	}
}
