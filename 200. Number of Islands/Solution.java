import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static class Pos {
		int x;
		int y;
		public Pos() {}
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int numIslands(char[][] grid) {

		boolean[][] visited = new boolean[grid.length][grid[0].length];

		Queue<Pos> queue1 = new LinkedList<>();
		Queue<Pos> queue0 = new LinkedList<>();

		for ( int i = 0; i < grid.length; i++ ) {

			for ( int j = 0; j < grid[0].length; j++ ) {

				if ( grid[i][j] == '1' ) {
					queue1.offer(new Pos(i, j));
				} else {
					queue0.offer(new Pos(i, j));
				}
			}
		}

		if ( queue1.size() == 0 ) {
			return 0;
		}

		if ( queue0.size() == 0 ) {
			return 1;
		}

		Pos start;
		Queue<Pos> queue = new LinkedList<>();

		while ( !queue1.isEmpty() ) {

			start = queue1.poll();

			if ( !visited[start.x][start.y] ) {

				queue.offer(queue1.poll());
				visited[start.x][start.y] = true;

				while ( !queue.isEmpty() ) {

					Pos curr = queue.poll();

					int i = curr.x;
					int j = curr.y;

					visited[i][j] = true;

					//	up
					if ( (i-1) >= 0 && !visited[i-1][j] ) {
						queue.offer(new Pos(i-1, j));
					}

//					if (  )
				}
			}
		}




		return 0;
	}

	public static void main(String[] args) {

		char[][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};

		char[][] grid2 = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};

		Solution s = new Solution();
		System.out.println(s.numIslands(grid));
	}
}
