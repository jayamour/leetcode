public class Solution {

	int maxArea = 0;
	int sum = 0;

	public int maxAreaOfIsland(int[][] grid) {

		boolean [][] visited = new boolean[grid.length][grid[0].length];

		for ( int i = 0; i < grid.length; i++ ) {

			for ( int j = 0; j < grid[i].length; j++ ) {

				if ( grid[i][j] == 1 ) {
					sum = 0;
					dfs(i, j, grid, visited);
				}
			}
		}

		return maxArea;
	}

	public void dfs(int i, int j, int[][] grid, boolean[][] visited) {

		if ( isLimit(i, j, grid) ) {
			return;
		}

		if ( grid[i][j] == 0 ) {
			return;
		}

		if ( visited[i][j] ) {
			return;
		}

		sum += 1;

		maxArea = Math.max(maxArea, sum);

		visited[i][j] = true;
		grid[i][j] = 2;

		//	up
		dfs(i-1, j, grid, visited);
		//	right
		dfs(i, j+1, grid, visited);
		//	down
		dfs(i+1, j, grid, visited);
		//	left
		dfs(i, j-1, grid, visited);
	}

	public boolean isLimit(int i, int j, int[][] grid) {

		if ( i < 0 || grid.length - 1 < i ) {
			return true;
		}

		return j < 0 || grid[i].length - 1 < j;
	}

	public void print(int[][] grid) {
		for ( int i = 0; i < grid.length; i++ ) {
			for ( int j = 0; j < grid[i].length; j++ ) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int[][] grid = {
				{0,0,1,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},
				{0,1,0,0,1,1,0,0,1,0,1,0,0},
				{0,1,0,0,1,1,0,0,1,1,1,0,0},
				{0,0,0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,1,1,0,0,0,0}};

//		int[][] grid = {
//				{1,1,0,0,0},
//				{1,1,0,0,0},
//				{0,0,0,1,1},
//				{0,0,0,1,1}
//		};

		Solution s = new Solution();
		System.out.println(s.maxAreaOfIsland(grid));
	}
}
