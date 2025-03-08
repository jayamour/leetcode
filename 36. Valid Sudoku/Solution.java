import java.util.HashSet;
import java.util.Set;

public class Solution {

	private static int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	private static int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

	public boolean isValidSudoku(char[][] board) {
		return checkRow(board) && checkCol(board) && checkBox(board);
	}

	private boolean checkBox(char[][] board) {
		//	(1,1), (1,4), (1,7)
		//	(4,1), (4,4), (4,7)
		//	(7,1), (7,4), (7,7)

		Set<Character> set;

		for ( int row = 1; row <= 7; row = row + 3 ) {

			for ( int col = 1; col <= 7; col = col + 3 ) {

				set = new HashSet<>();

				for ( int i = 0; i < 9; i++ ) {
					int nx = row + dx[i];
					int ny = col + dy[i];

					if ( board[nx][ny] != '.' ) {
						if ( !set.add(board[nx][ny]) ) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	private boolean checkCol(char[][] board) {

		Set<Character> set;

		for ( int j = 0; j < board[0].length; j++ ) {
			set = new HashSet<>();
			for ( int i = 0; i < board.length; i++ ) {
				if ( board[i][j] != '.' ) {
					if ( !set.add(board[i][j]) ) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private boolean checkRow(char[][] board) {

		Set<Character> set;

		for ( int i = 0; i < board.length; i++ ) {

			set = new HashSet<>();

			for ( int j = 0; j < board[i].length; j++ ) {
				if ( board[i][j] != '.' ) {
					if ( !set.add(board[i][j]) ) {
						return false;
					}
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board =
				{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
						, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
						, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
						, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
						, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
						, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
						, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
						, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
						, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

		System.out.println(solution.isValidSudoku(board));
	}
}
