import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int maxProduct(int[] nums) {

		//	20,000

		List<List<Integer>> ans = new ArrayList<>();

		for ( int i = 0; i < 20000; i++ ) {
			ans.add(new ArrayList<>());
		}

		int[] minusCnt = new int[20000];
		int[] max = new int[20000];

		int cnt = 0;

		//	-2, 0, -1
		for ( int i = 0; i < nums.length; i++ ) {

			if ( nums[i] == 0 ) {
				cnt++;
			} else {

				if ( nums[i] < 0 ) {
					minusCnt[cnt]++;
				}

				ans.get(cnt).add(nums[i]);
			}
		}

		int tmp = 1;
		int [] arr = new int[2];

		for ( int i = 0; i <= cnt; i++ ) {

			tmp = 1;

			if ( minusCnt[i] % 2 == 0 ) {

				for ( Integer x : ans.get(i) ) {
					tmp = tmp * x;
				}

			} else {

				arr[0] = 1;
				arr[1] = 1;
				int k;

				//	2, 3, -1, 7
				for ( Integer x : ans.get(i) ) {

					//	6 = 2 * 3
					arr[0] = arr[0] * x;

					//		2 > 1
					if ( arr[0] > arr[1] ) {
						arr[1] = arr[0];
					}
				}
			}
		}

		return tmp;
	}

	public static void main(String[] args) {

		int[] nums = {2, 3, -1, 7, 0, 5, 8, 0, 8, -2, -1, -3, -1};

		Solution s = new Solution();
		System.out.println(s.maxProduct(nums));
	}
}
