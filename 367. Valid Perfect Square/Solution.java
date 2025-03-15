public class Solution {

	public boolean isPerfectSquare(int num) {

		if ( num == 1 ) return true;

		long left = 2, right = num;

		int count = 0;

		while ( left <= right ) {

			long mid = left + (right - left) / 2;

			if ( mid * mid == num ) {
				return true;
			} else if ( mid * mid < num ) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPerfectSquare(2147483647));
//		System.out.println(solution.isPerfectSquare(14));
//		System.out.println(solution.isPerfectSquare(16));
	}
}
