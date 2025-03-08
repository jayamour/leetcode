import java.util.function.Predicate;

public class Solution {

	public int findUnsortedSubarray(int[] nums) {

		int l = nums.length;

		int max = nums[0];
		int min = nums[l-1];

		int start = -1, end = -2;


		//	v			  v
		//	2,6,4,8,10,9,15
		for ( int i = 1; i < l; i++ ) {


			max = Math.max(max, nums[i]);
			min = Math.min(min, nums[l - 1 - i]);

//			System.out.println(i + ": " + nums[i] + " vs " + max);

			if ( nums[i] < max ) {
				end = i;
			}

//			System.out.println(i + ": " + nums[l - i - 1] + " vs " + min);
			if ( nums[l - 1 - i] > min ) {
				start = l - 1 - i;
			}
		}

//		System.out.println("end = " + end);
//		System.out.println("start = " + start);

		return end - start + 1;
	}

	public int findUnsortedSubarray2(int[] nums) {
		//	v			  v
		//	2,6,4,8,10,9,15

		//	  v		   v
		//	2,6,4,8,10,9,15

		//    v v	   v
		//	2,6,4,8,10,9,15

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		int l = nums.length;


		for ( int i = 0; i < (l-1); i++ ) {

			if ( nums[i] > nums[i+1] ) {
				min = Math.min(min, nums[i+1]);
			}
		}

		for ( int i = (l-1); i > 0; i-- ) {

			if ( nums[i-1] > nums[i] ) {
				max = Math.max(max, nums[i-1]);
			}
		}

		if ( min == Integer.MAX_VALUE && max == Integer.MIN_VALUE ) {
			return 0;
		}

		int start = 0, end = l - 1;

		for ( start = 0; start < l; start++ ) {
			if ( nums[start] > min ) {
				break;
			}
		}

		for ( end = (l-1); end >= 0; end-- ) {
			if ( nums[end] < max ) {
				break;
			}
		}

		return end - start + 1;
	}

	public static void main(String[] args) {

		int[] nums = {2,6,4,8,10,9,15};

		Solution s = new Solution();
		System.out.println(s.findUnsortedSubarray(nums));
	}
}
