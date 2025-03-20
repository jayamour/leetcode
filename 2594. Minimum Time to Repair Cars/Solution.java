import java.util.Arrays;

public class Solution {

	public long repairCars(int[] ranks, int cars) {

		long left = 0;
		long right = (long) Arrays.stream(ranks).max().getAsInt() * cars * cars;

		while( left < right ) {

			long mid = left + (right - left) / 2;

			long sum = 0;

			for( int i = 0; i < ranks.length; i++ ) {
				sum += Math.sqrt(mid / ranks[i]);
			}

			if( sum < cars ) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return right;
	}

	public static void main(String[] args) {

		Solution s = new Solution();

		int[] nums = { 4, 2, 3, 1 };
		int cars = 10;

//		int[] nums = { 5, 1, 8 };
//		int cars = 6;

		System.out.println(s.repairCars(nums, cars));
	}
}
