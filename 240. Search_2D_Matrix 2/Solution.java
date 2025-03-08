public class Solution {

	boolean found = false;

	int row = 0;
	int col = 0;

	public boolean searchMatrix(int[][] matrix, int target) {

		row = matrix.length;
		col = matrix[0].length;

		//	0 1 2 3 4
//		print(matrix);

		int startPos = findNearPos(matrix[0], col-1, target);

		if ( found ) {
			return found;
		}

		for ( int i = 1; i < row; i++ ) {

			if ( matrix[i][startPos] == target ) {
				return true;
			} else if ( matrix[i][startPos] < target ) {
				continue;
			} else {
				startPos = findNearPos(matrix[i], startPos, target);
			}
		}

		return found;
	}

	public int findNearPos(int[] arr, int end, int target) {

		if ( arr[0] == target ) {
			found = true;
			return 0;
		}

		if ( arr[end] == target ) {
			found = true;
			return end;
		}

		if ( arr[end] < target ) {
			return end;
		}

		int start = 0;
		int mid = 0;

		if ( start == end ) {
			return start;
		}

		//	1,4,7,11,16,17,19,22,24,30,33
		while ( start <= end ) {

			if ( (end - start) == 1 ) {
				return start;
			}

			mid = (start + end) / 2;

			if ( arr[mid] == target ) {
				found = true;
				return mid;
			} else if ( arr[mid] < target ) {
				start = mid;
			} else {
				end = mid;
			}
		}

		return mid;
	}

	public void print(int[][] matrix) {

		for ( int i = 0; i < matrix.length; i++ ) {
			for ( int j = 0; j < matrix[0].length; j++ ) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int[][] matrix =
				{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};

		int target = -2;

		Solution s = new Solution();
//		System.out.println(s.searchMatrix(matrix, target));

//		int [][] arr = {{-5}};
//		int [][] arr = {{1,4}, {2,5}};
//		System.out.println(s.searchMatrix(arr, target));
//		System.out.println(s.findNearPos(arr, 4, 14));
//		System.out.println(s.found);

		int [] input = {1,4};
		System.out.println(s.findNearPos(input, 1, 5));
	}
}
