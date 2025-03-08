import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {

	public int orangesRotting(int[][] grid) {

		HashMap<Integer, Integer> map = new HashMap<>();

		Queue<Pair> queue = new LinkedList<>();

		for ( int i = 0; i < grid.length; i++ ) {
			for ( int j = 0; j < grid[i].length; j++ ) {

				map.merge(grid[i][j], 1, Integer::sum);

				if ( grid[i][j] == 2 ) {
					queue.offer(new Pair(i, j));
				}
			}
		}

		if ( map.get(1) == null ) {
			return 0;
		}

		int cnt = 0;

		while ( !queue.isEmpty() ) {

			cnt++;

			int size = queue.size();

			for ( int i = 0; i < size; i++ ) {

				Pair p = queue.poll();

				if ( isValid(p.x-1, p.y, grid) ) {
					grid[p.x-1][p.y] = 2;
					int res = updateMap(p.x-1, p.y, map, grid);

					if ( res == 0 ) {
						return cnt;
					}

					queue.offer(new Pair(p.x-1, p.y));
				}

				if ( isValid(p.x+1, p.y, grid) ) {
					grid[p.x+1][p.y] = 2;
					int res = updateMap(p.x+1, p.y, map, grid);

					if ( res == 0 ) {
						return cnt;
					}

					queue.offer(new Pair(p.x+1, p.y));
				}

				if ( isValid(p.x, p.y-1, grid) ) {
					grid[p.x][p.y-1] = 2;
					int res = updateMap(p.x, p.y-1, map, grid);

					if ( res == 0 ) {
						return cnt;
					}

					queue.offer(new Pair(p.x, p.y-1));
				}

				if ( isValid(p.x, p.y+1, grid) ) {
					grid[p.x][p.y+1] = 2;
					int res = updateMap(p.x, p.y+1, map, grid);

					if ( res == 0 ) {
						return cnt;
					}

					queue.offer(new Pair(p.x, p.y+1));
				}
			}
		}

		if ( map.get(1) != null && map.get(1) > 0 ) {
			return -1;
		}

		print(grid);

		return 0;
	}

	public int updateMap(int x, int y, HashMap<Integer, Integer> map, int[][] grid) {

		if ( grid[x][y] == 2 && map.get(1) != null && map.get(1) > 0 ) {
			map.put(1, map.get(1) - 1);
		}

		return map.get(1);
	}

	public boolean isValid(int x, int y, int[][] grid) {

		int row = grid.length;
		int col = grid[0].length;

		if ( x < 0 || x >= row || y < 0 || y >= col ) {
			return false;
		}

		if ( grid[x][y] == 0 || grid[x][y] == 2 ) {
			return false;
		}

		return x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1;
	}

	public void print(int[][] arr) {
		for ( int[] a : arr ) {
			for ( int k : a ) {
				System.out.print(k + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

//		int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
//		int[][] grid = {{2,1,1}, {0,1,1}, {1,0,1}};
		int[][] grid = {{0, 2}};

		Solution s = new Solution();
		System.out.println(s.orangesRotting(grid));
	}
}
