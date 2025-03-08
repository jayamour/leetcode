import java.util.PriorityQueue;

public class Solution {

	public int[] searchRange(int[] nums, int target) {

		int [] answer = new int[2];

		int posL = 0;
		int posR = nums.length - 1;
		posL = binarySearch(nums, target, true);
		posR = binarySearch(nums, target, false);

		answer[0] = posL;
		answer[1] = posR;

		return answer;
	}

	public int binarySearch(int[] nums, int target, boolean toLeft) {

		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		int res = -1;

		while ( start <= end ) {

			mid = (start + end) / 2;

			if ( nums[mid] < target ) {
				start = mid + 1;
			} else if ( nums[mid] > target ) {
				end = mid - 1;
			} else {
				res = mid;
				if ( toLeft ) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}

		return res;
	}

	public void print(int[] arr) {
		for ( int i : arr ) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int [] nums = {5,7,7,8,8,10};
//		int [] nums = {1, 4};
		int target = 8;

		Solution s = new Solution();
		int [] answer = s.searchRange(nums, target);

		for ( int i : answer ) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
