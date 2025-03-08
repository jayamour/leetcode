import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {

	public int findKthLargest(int[] nums, int k) {

		//	1 <= k <= nums.length <= 10^5
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for ( int i = 0; i < k; i++ ) {
			pq.add(nums[i]);
		}

		for ( int i = k; i < nums.length; i++ ) {

			if ( nums[i] > pq.peek() ) {
				pq.poll();
				pq.add(nums[i]);
			}
		}

		return pq.peek();
	}

	public static void main(String[] args) {

		Solution s = new Solution();

		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		/**
		 * 2 2 3 3
		 * 2 3 3 4
		 * 3 3 4 5
		 * 3 4 5 5
		 * 4 5 5 6
		 */

		System.out.println(s.findKthLargest(nums, k));
	}
}