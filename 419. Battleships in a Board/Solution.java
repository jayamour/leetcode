import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	int count = 0;

	public int countBattleships(char[][] board) {

		int m = board.length, n = board[0].length;

		for ( int i = 0; i < m; i++ ) {
			for ( int j = 0; j < n; j++ ) {
				if ( board[i][j] == 'X' ) {
					dfs(i, j, board);
				}
			}
		}

		return count;
	}

	private void dfs(int i, int j, char[][] board) {

		Deque<int[]> stack = new ArrayDeque<>();
		stack.push(new int[]{i, j});

		while ( !stack.isEmpty() ) {

			int[] cur = stack.pop();
//			board[cur[0]][cur[1]] = '.';

			for ( int k = 0; k < 4; k++ ) {
				int nx = cur[0] + dx[k];
				int ny = cur[1] + dy[k];

				if ( nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 'X' ) {
					stack.push(new int[]{nx, ny});
					board[nx][ny] = '.';
				}
			}
		}

		count++;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
		System.out.println(solution.countBattleships(board));
	}
}
