import java.util.Arrays;

public class Solution {

	public int minCapability(int[] nums, int k) {

		int left = Arrays.stream(nums).min().getAsInt();
		int right = Arrays.stream(nums).max().getAsInt();

		while ( left < right ) {

			int mid = left + (right - left) / 2;

			if ( canRob(nums, mid, k) ) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	private static boolean canRob(int[] nums, int candidate, int k) {

		int count = 0;
		int i = 0;
		int n = nums.length;

		while ( i < n ) {
			if ( nums[i] <= candidate ) {
				count++;
				i += 2;
			} else {
				i += 1;
			}
		}

		return count >= k;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		System.out.println(solution.minCapability(new int[]{2, 3, 5, 9}, 2));
		System.out.println(solution.minCapability(new int[]{2, 7, 9, 3, 1}, 2));
	}
}
