import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

	public int[][] findFarmland(int[][] land) {

		List<int[]> result = new ArrayList<>();

		for ( int i = 0; i < land.length; i++ ) {
			for ( int j = 0; j < land[0].length; j++ ) {
				if ( land[i][j] == 1 ) {
					int[] rectangle = dfs(i, j, land);
					result.add(rectangle);
				}
			}
		}

		return result.toArray(new int[result.size()][] );
	}

	private int[] dfs(int i, int j, int[][] land) {

		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[] { i, j });
		land[i][j] = -1;

		int minX = i, minY = j;
		int maxX = i, maxY = j;

		int[] dx = { 0, 1 };
		int[] dy = { 1, 0 };

		while ( !stack.isEmpty() ) {

			int[] curr = stack.pop();
			int x = curr[0], y = curr[1];

			for ( int k = 0; k < 2; k++ ) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				if ( nx >= 0 && nx < land.length && ny >= 0 && ny < land[0].length && land[nx][ny] == 1 ) {
					stack.push(new int[] { nx, ny });
					land[nx][ny] = -1;

					minX = Math.min(minX, nx);
					minY = Math.min(minY, ny);
					maxX = Math.max(maxX, nx);
					maxY = Math.max(maxY, ny);
				}
			}
		}

		return new int[] { minX, minY, maxX, maxY };
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] grid = s.findFarmland(new int[][] { { 1, 1, 0, 1, 1, 1 }, { 0, 0, 0, 1, 1, 1 }, { 0, 1, 0, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1 }, {0, 0, 1, 1, 1, 1 } });
	}
}
