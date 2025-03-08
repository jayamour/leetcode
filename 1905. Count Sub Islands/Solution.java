import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public int countSubIslands(int[][] grid1, int[][] grid2) {

		int count = 0;

		for (int i = 0; i < grid2.length; i++ ) {
			for ( int j = 0; j < grid2[0].length; j++ ) {
				if ( grid1[i][j] == 1 && grid2[i][j] == 1 ) {
					if ( dfs(i, j, grid1, grid2) ) {
						count++;
					}
				}
			}
		}

		return count;
	}

	private boolean dfs(int i, int j, int[][] grid1, int[][] grid2) {

		boolean flag = true;
		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[]{i, j});
		grid2[i][j] = -1;

		while ( !stack.isEmpty() ) {

			int[] curr = stack.pop();
			int x = curr[0];
			int y = curr[1];

			for ( int k = 0; k < 4; k++ ) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if ( nx >= 0 && nx < grid2.length && ny >=0 && ny < grid2[0].length && grid2[nx][ny] == 1 ) {

					if ( grid1[nx][ny] == 0 ) {
						flag = false;
					}

					grid2[nx][ny] = -1;
					stack.push(new int[]{nx, ny});
				}
			}
		}

		return flag;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
		int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
		System.out.println(solution.countSubIslands(grid1, grid2));
	}
}
