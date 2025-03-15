import java.util.Arrays;

public class Solution {

	public int minEatingSpeed(int[] piles, int h) {

		int left = 1;
		int right = Arrays.stream(piles).max().getAsInt();

		while ( left < right ) {

			int mid = left + (right - left) / 2;

			int sum = 0;

			for ( int pile : piles ) {
				sum += (int) Math.ceil((double) pile / mid);
			}

			if ( sum > h ) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		return right;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
	}
}
