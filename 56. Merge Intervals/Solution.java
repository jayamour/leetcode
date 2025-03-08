import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

//		print(intervals);

		List<int[]> ans = new ArrayList<>();

		for ( int[] ints : intervals ) {

			if ( ans.isEmpty() || ints[0] > ans.get(ans.size() - 1)[1] ) {
				ans.add(ints);
			} else {
				ans.get(ans.size() - 1)[1] = Math.max(ints[1], ans.get(ans.size() - 1)[1]);
			}
		}

		return ans.toArray(new int[ans.size()][2]);
	}

	public int[][] merge2(int[][] intervals) {

		List<int[]> list = new ArrayList<>();

		int start = 1;

		for ( int i = 0; i < (intervals.length - 1); i++ ) {

			int[] arr1 = intervals[i];
			int[] arr2;

//			System.out.println("i: " + i);
			for ( int j = (i+1); j < (intervals.length); j++ ) {

				arr2 = intervals[j];

				System.out.println("i: " + i + ", j:" + j);

				System.out.println(arr1[1] + " vs " + arr2[0]);
				if ( arr1[1] >= arr2[0] ) {
					if ( arr1[1] < arr2[1] ) {
						arr2[0] = arr1[0];
						break;
					}
				} else {
					list.add(intervals[j-1]);
					break;
				}
			}

			//	0, 1
			//	1, 2
			//	2, 3

			if ( i == (intervals.length) - 2 ) {

				System.out.println("!!!!!!!!!!!!\t" + i);
				for ( int t : arr1 ) {
					System.out.print(t + " ");
				}
				System.out.println();
				System.out.println("!!!!!!!!!!!!");

//				if ( arr1[1] )
			}
		}


		print(intervals);

		System.out.println("list.size() = " + list.size());

		for ( int[] x : list ) {

			for ( int k : x ) {
				System.out.print(k + " ");
			}
			System.out.println();
		}

		int[][] result = new int[list.size()][2];

		for ( int i = 0; i < list.size(); i++ ) {
			result[i] = list.get(i);
		}

		return result;
	}

	public void print(int[][] arr) {

		for ( int i = 0; i < arr.length; i++ ) {

			for ( int j : arr[i] ) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int[][] i = {{1,3}, {15,18}, {2,6}, {8,10}};

		Solution s = new Solution();
		s.merge(i);
	}
}
