import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public int jump(int[] nums) {

		int l = 0, r = 0;
		int res = 0;

		//	l: 0, r: 0
		while ( r < nums.length - 1 ) {
			//	1 1 1 1
			//	3,2,1,1,4,1,2,1

			int far = 0;

			//	i:1 ~ 4
			for ( int i = l; i < (r + 1); i++ ) {
				far = Math.max(far, i + nums[i]);
			}

			l = r + 1;
			r = far;

			res++;
		}

		return res;
	}

	public int jump2(int[] nums) {

		if ( nums[0] == 0 || (nums.length == 1 && nums[0] == 1) ) {
			return 0;
		}

		int[] res = new int[nums.length];
		Arrays.fill(res, 1001);
		//	1 2 3
		//	2 3 3 4
		//	3 4 5 6 7


		
		//	2 3 1 1 4
		//	  1 1
		//		2 2 2

		int cnt = 1;

		for ( int x = 0; x < nums.length; x++ ) {

			//	2
			int k = nums[x];
			System.out.println("k = " + k + ", cnt: " + cnt);

			for ( int i = 1; i <= k; i++ ) {

				if ( (x + i) >= nums.length ) {
					break;
				}


				if ( res[x + i] == 1001 ) {
					res[x + i] = cnt;
					continue;
				}

				res[x + i] = Math.min(res[x + i], cnt);
//				res[x + i] = res[x + i] + cnt;
			}

			print(res);

			cnt++;
		}

		return res[res.length - 1];
	}

	public void print(int[] arr) {
		for ( int i : arr ) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

//		int[] nums = {2,3,1,1,4};
		int[] nums = {3,2,1,1,4,1,2,1};

		Solution s = new Solution();
		System.out.println(s.jump(nums));
	}
}
