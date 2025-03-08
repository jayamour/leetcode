import java.util.Arrays;
import java.util.Collections;

public class Solution {

	public int splitArray(int[] nums, int k) {

		int high = 0;
		int low = 0;

		for ( int i = 0; i < nums.length; i++ ) {
			System.out.print(nums[i] + " ");
			high += nums[i];
			low = Math.max(low, nums[i]);
		}
		System.out.println();

		int mid = 0;
		int sum = 0;
		int count = 1;

		//	10 <= 32
		while ( low <= high ) {

			count = 1;

			//	21
			mid = (low + high) / 2;
			sum = 0;

			System.out.println("low: " + low + ", high: " + high);
			System.out.println("=== mid: " + mid);

			//	7 2 5 10 8
			for ( int i = 0; i < nums.length; i++ ) {

				sum += nums[i];

				System.out.println("i: " +  i + ", " + nums[i] + ", sum: " + sum);

				if ( mid < sum ) {
					System.out.println("&&sum: " + sum);
					sum = nums[i];
					System.out.println("sum: " + sum);
					count++;

					System.out.println("   count: " + count);
					//	3 < 2
					if ( k < count ) {
						System.out.println("why?");
//					low = mid + 1;
						break;
					}
				}
			}

			System.out.println("k: " + k + ", cnt::" + count);
			//	2 < 3
			if ( k < count ) {
				System.out.println("mid : " + mid);
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return low;
	}

	public static void main(String[] args) {

		int[] nums = {7,2,5,10,8};
//		int[] nums = {1,4,4};

		//	1,2,2,3,3,4
//		int [] nums = {2,3,1,2,4,3};
		int k = 2;

		Solution s = new Solution();
		System.out.println(s.splitArray(nums, k));
	}
}
