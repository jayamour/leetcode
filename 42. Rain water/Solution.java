public class Solution {

	static int trap(int[] height) {

		int start = 0;
		int end = height.length - 1;

		int leftMax = height[start];
		int rightMax = height[end];

		int sum = 0;

		int temp = 0;

				//	0 < 11
		while ( start < end ) {

			if ( leftMax <= rightMax ) {
				temp = Math.min(leftMax, rightMax) - height[start];
			} else {
				temp = Math.min(leftMax, rightMax) - height[end];
			}

			if ( temp > 0 ) {
				sum += temp;
			}

			if ( leftMax <= rightMax ) {
				start++;

				if ( leftMax < height[start] ) {
					leftMax = height[start];
				}

			} else {
				end--;

				if ( rightMax < height[end] ) {
					rightMax = height[end];
				}
			}

		}

		return sum;
	}

	public static void main(String[] args) {

		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//		int[] height = {5, 4, 1, 2};

		print(height);

		System.out.println("answer = " + trap(height));
	}

	static void print(int[] arr) {

		for (int j : arr) {
			System.out.print(j + " ");
		}
		System.out.println();
	}
}