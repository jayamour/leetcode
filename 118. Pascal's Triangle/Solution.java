import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<Integer>> generate(int numRows) {

		List<List<Integer>> ans = new ArrayList<>();

		int[][] arr = new int[numRows + 1][numRows + 2];

		//	0
		//	0 1 0
		//	0 1 1 0

		arr[1][1] = 1;
		List<Integer> list = new ArrayList<>();

		list.add(1);
		ans.add(list);

		if ( numRows == 1 ) {
			return ans;
		}

		for ( int i = 2; i <= numRows; i++ ) {

			list = new ArrayList<>();

			for ( int j = 1; j < (i + 1); j++ ) {

				arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				list.add(arr[i][j]);
			}
			ans.add(list);
		}

//		printArr(arr);

		return ans;
	}

	public void printArr(int[][] arr) {

		for ( int i = 1; i < arr.length; i++ ) {

			for ( int j = 0; j < arr[i].length; j++ ) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		//1	0 1 0
		//2	0 1 1 0
		//3	1 2 1
		//4	0 1 3 3 1 0
		//5	1 4 6 4 1
		//6	1 5 10 10 5 1
		//7 1 6 15 20 15 6 1

		Solution s = new Solution();
		System.out.println(s.generate(7));
	}
}
