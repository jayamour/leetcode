public class Solution {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		if ( nums1.length > nums2.length ) {
			return findMedianSortedArrays(nums2, nums1);
		}

		int m = nums1.length;	// nums1 배열의 길이
		int n = nums2.length;	// nums2 배열의 길이
		int maxLeft = 0, minRight = m, half = (m + n + 1) / 2;

		while ( maxLeft <= minRight ) {
			int i = (maxLeft + minRight) / 2;
			int j = half - i;

			int maxLeftX = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];
			int minRightX = (i == m) ? Integer.MAX_VALUE : nums1[i];

			int maxLeftY = (j == 0) ? Integer.MIN_VALUE : nums2[j-1];
			int minRightY = (j == n) ? Integer.MAX_VALUE : nums2[j];

			if ( maxLeftX <= minRightY && maxLeftY <= minRightX ) {
				if ( (m + n) % 2 == 0 ) {
					return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return Math.max(maxLeftX, maxLeftY);
				}
			} else if ( maxLeftX > minRightY ) {
				minRight = i - 1;
			} else {
				maxLeft = i + 1;
			}
		}

		return 0.0;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums1 = {1, 3, 8, 9, 15};
		int[] nums2 = {7, 11, 18, 19, 21, 25};

		System.out.println(s.findMedianSortedArrays(nums1, nums2));
	}
}
