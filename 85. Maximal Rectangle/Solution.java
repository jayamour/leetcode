import java.util.Arrays;
import java.util.Stack;

public class Solution {

	static class Pair {
		int idx;
		int height;

		public Pair(int i, int h) {
			this.idx = i;
			this.height = h;
		}
		
		@Override
		public String toString() {
			return idx + ", " + height;
		}
	}

	public int maximalRectangle(char[][] matrix) {

		int[][] arr = new int[matrix.length][matrix[0].length];
		int[][] acc = new int[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == '1') {
					arr[i][j] = 1;
				} else {
					arr[i][j] = 0;
				}
			}
		}

//		printArr(arr);

		for ( int i = 0; i < arr[0].length; i++ ) {
			acc[0][i] = arr[0][i];
		}

		int answer = findMaxRectangle(acc[0]);

		for ( int i = 1; i < arr.length; i++ ) {

			for ( int j = 0; j < arr[0].length; j++ ) {

				if ( acc[i-1][j] >= 1 && arr[i][j] == 1 ) {
					acc[i][j] = acc[i-1][j] + 1;
				} else if ( arr[i-1][j] == 0 ) {
					acc[i][j] = arr[i][j];
				} else if ( arr[i][j] == 0 ) {
					acc[i][j] = 0;
				}
			}

			int x = findMaxRectangle(acc[i]);

			answer = Math.max(answer, findMaxRectangle(acc[i]));
		}

//		printArr(acc);

		return answer;
	}

	public int findMaxRectangle(int[] arr) {

		int maxValue = 0;

		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(0, arr[0]));

		//	2, 0, 2, 1, 1
		//	2, 1, 5, 6, 2, 3
		for ( int i = 1; i < arr.length; i++ ) {

			Pair temp = stack.peek();
			Pair newItem = new Pair(i, arr[i]);

			if ( temp.height <= newItem.height ) {
				stack.push(newItem);
			} else {

				int newIdx = 0;

				while ( !stack.isEmpty() && stack.peek().height > arr[i] ) {
					Pair pop = stack.pop();
					newIdx = pop.idx;
					maxValue = Math.max(maxValue, (i-pop.idx) * pop.height);
				}

				newItem.idx = newIdx;
				stack.push(newItem);
			}
		}

		while ( !stack.isEmpty() ) {
			Pair p = stack.pop();
			maxValue = Math.max(maxValue, (arr.length - p.idx) * p.height);
		}

		return maxValue;
	}

	public int maximalRectangle2(char[][] matrix) {

		int[][] arr = new int[matrix.length][matrix[0].length];
		int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];

		for ( int i = 1; i < (matrix.length + 1); i++ ) {

			for ( int j = 1; j < (matrix[0].length + 1); j++ ) {

				if ( matrix[i-1][j-1] == '1' ) {
					arr[i-1][j-1] = 1;
				} else {
					arr[i-1][j-1] = 0;
				}
			}
		}

		for ( int i = 1; i < (matrix.length + 1); i++ ) {

			for ( int j = 1; j < (matrix[0].length + 1); j++ ) {

				dp[i][j] = arr[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
			}
		}

//		printArr(dp);

		int answer = 0;

		//	[2][3] ~ [3][5]
		//	supposed to be (3-2+1) x (5-3+1) = 6
		//	[3][5] - [1][5] - [3][2] + [1][2]

		int supposed = 0;
		int sum = 0;

		for ( int i = 1; i < matrix.length + 1; i++ ) {
			for ( int j = 1; j < matrix[0].length + 1; j++ ) {
				for ( int x = i; x <  matrix.length + 1; x++  ) {
					for ( int y = j; y < matrix[0].length + 1; y++ ) {

//						System.out.println("[" + i + "]["+ j + "] ~ [" + x + "][" + y +"]");
						supposed = (x-i+1) * (y-j+1);

						sum = dp[x][y] - dp[x-1][y] - dp[x][j-1] + dp[i-1][j-1];

						if ( sum == supposed ) {
//							System.out.println("[" + i + "]["+ j + "] ~ [" + x + "][" + y +"] !!!");


							answer = Math.max(supposed, answer);
						}
					}
				}
			}
		}

		return answer;
	}

	public void printArr(int[][] arr) {

		for ( int i = 0; i < arr.length; i++ ) {

			for ( int j = 0; j < arr[0].length; j++ ) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		char [][] matrix =
				{
						{'1','0','1','0','0'},
						{'1','0','1','1','1'},
						{'1','1','1','1','1'},
						{'1','0','0','1','0'}
				};

//		char[][] matrix = {{'1', '1'}};

//		char[][] matrix = {{'0', '1'}, {'1', '0'}};

//		int [] arr = {2, 1, 5, 6, 2, 3};
		int [] arr = {2, 0, 2, 1, 1};

		Solution s = new Solution();
		System.out.println(s.maximalRectangle(matrix));
//		System.out.println(s.findMaxRectangle(arr));
	}
}
