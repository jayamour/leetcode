import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	static class Pos {
		int i;
		int j;
		public Pos() {}
		public Pos(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	List<List<String>> result = new ArrayList<>();

	public List<List<String>> solveNQueens(int n) {

		List<Pos> list = new ArrayList<>();

		String[][] board;

		for ( int j = 0; j < n; j++ ) {
			list.add(new Pos(0, j));
			board = new String[n][n];

			for ( int z = 0; z < n; z++ ) {
				Arrays.fill(board[z], ".");
			}

			dfs(j, 0, n-1, board, list);
			list.remove(list.size()-1);
		}

		return result;
	}

	public void dfs(int j, int i, int n, String[][] board, List<Pos> list) {

		if ( i == n ) {

			for ( Pos p : list ) {
				board[p.i][p.j] = "Q";
			}

			List<String> str = new ArrayList<>();

			for ( int k = 0; k < board.length; k++ ) {

				StringBuilder s = new StringBuilder();

				for ( int l = 0; l < board[k].length; l++ ) {
					s.append(board[k][l]);
				}
				str.add(s.toString());
			}

			result.add(str);

			return;
		}

		/*
			1 0 0 0
			0 0 1 0
			0 0 0 0
			0 0 0 0
		 */

		for ( int x = 0; x <= n; x++ ) {

			if ( check(i+1, x, list) ) {
				dfs(x, i+1, n, board, list);

				Pos p = list.get(list.size()-1);
				board[p.i][p.j] = ".";

				list.remove(list.size()-1);
			}
		}
	}

	public boolean check(int i, int j, List<Pos> list) {

		for ( Pos pos : list ) {

			if ( pos.i == i || pos.j == j ) {
				return false;
			}

			if ( Math.abs(pos.i - i) == Math.abs(pos.j - j) ) {
				return false;
			}
		}
		list.add(new Pos(i, j));

		return true;
	}

	public void print(String [][] str) {
		for ( int i = 0; i < str.length; i++ ) {
			for ( int j = 0; j < str[0].length; j++ ) {
				System.out.print(str[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		Solution s = new Solution();
		System.out.println(s.solveNQueens(5));
	}
}
