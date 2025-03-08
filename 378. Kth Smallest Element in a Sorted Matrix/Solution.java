public class Solution {

	public int kthSmallest(int[][] matrix, int k) {

		/*
		 1  5  9 10
		10 11 12 13
		13 14 14 15
		15 16 16 17
		 */

		//	4
		int n = matrix.length;
		
		int x = k / n;
		int y = k % n - 1;

		System.out.println("x = " + x);
		System.out.println("y = " + y);

		for ( int i = 0; i <= x; i++ ) {

			//	0, n-1
			//	1, 0

			if ( matrix[i][n-1] == matrix[i+1][0] ) {
				continue;
			} else {
				change(i+1, matrix);
			}
		}

		return 0;
	}

	public static void main(String[] args) {

		int [][] mat = {
				{1,5,9,10},
				{10,11,13,14},
				{12,13,15,16},
				{14,15,16,17}
		};

		Solution s = new Solution();

		System.out.println(s.kthSmallest(mat, 11));
	}
}
