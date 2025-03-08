import java.util.ArrayList;
import java.util.List;

public class Solution {

	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};

	public boolean exist(char[][] board, String word) {

		for ( int i = 0; i < board.length; i++ ) {
			for ( int j = 0; j < board[i].length; j++ ) {
				if (board[i][j] == word.charAt(0)) {
					if ( dfs(i, j, 0, new boolean[board.length][board[0].length], board, word) ) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean dfs(int x, int y, int idx, boolean[][] visited, char[][] board, String word) {

//		System.out.println("word.length() = " + word.length());

		if ( idx == word.length() ) {
			return true;
		}

		System.out.println(x + " " + y + ": " + idx + "\t" + word.charAt(idx));

		if ( !isPossible(x, y, board) ||  visited[x][y] || board[x][y] != word.charAt(idx) ) {
			return false;
		}

		visited[x][y] = true;

		boolean found = false;

		for ( int i = 0; i < 4; i++ ) {

			int nx = x + dx[i];
			int ny = y + dy[i];

			found = found || dfs(nx, ny, idx + 1, visited, board, word);
		}

		visited[x][y] = false;

		return found;
	}

	private boolean isPossible(int nx, int ny, char[][] board) {
		return nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		char[][] board = new char[][]{{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
//		char[][] board = new char[][]{{'a', 'a'}};
		char[][] board = new char[][]{{'a'}};
		System.out.println(solution.exist(board, "a"));
//		System.out.println(solution.exist(board, "ABCCED"));
//		System.out.println(solution.exist(board, "SEE"));
//		System.out.println(solution.exist(board, "aaa"));
	}
}
