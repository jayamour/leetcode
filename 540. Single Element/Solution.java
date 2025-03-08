public class Solution {

	public int singleNonDuplicate(int[] nums) {


		//	9
		//	4
		//	2


		int start = 0, end = nums.length - 1;
		int mid = 0;

		while ( start < end ) {

			//	= (0	 + 4  ) / 2;
			mid = (start + end) / 2;

			System.out.println(start + "  " + mid + "  " + end);

			if ( start == mid || end == mid ) {
				return nums[mid];
			}

			if ( mid == 1 ) {

				if ( nums[0] != nums[1] ) {
					return nums[0];
				} else {
					return nums[2];
				}
			}

			//	0 1 2 3 4  5  6
			// 	3 3 7 7 10 11 11
			if ( mid == nums.length - 2 ) {

				if ( nums[mid] != nums[mid + 1] ) {
					return 0;
				}
			}

			//	0  1  2  3  4  5  6  7  8
			//	1, 1, 2, 3, 3, 4, 4, 8, 8

			if ( mid % 2 == 0 ) {
				//	check right
				//	mid: 4
				if ( nums[mid] != nums[mid + 1] ) {
					end = mid;
				} else {
					start = mid;
				}
			} else {
				//	check left
				if ( nums[mid - 1] != nums[mid] ) {
					//	0 1 2 3 4  5  6
					// 	3 3 7 7 10 11 11
					end = mid;
				} else {
					start = mid;
				}
			}

		}

		//	0  1  2  3  4  5  6  7  8
		//	1, 1, 2, 3, 3, 4, 4, 8, 8

		return 0;
	}

	public static void main(String[] args) {

//		int [] nums = {1,1,2,3,3,4,4,8,8};
		int [] nums = {3,3,7,7,10,11,11};

		Solution s = new Solution();
		System.out.println(s.singleNonDuplicate(nums));
	}
}
