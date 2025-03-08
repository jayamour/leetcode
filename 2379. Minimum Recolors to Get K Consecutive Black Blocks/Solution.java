public class Solution {

	public int minimumRecolors(String blocks, int k) {
		int l = 0;
		int r = 0;

		int ans = k;
		int recolor = 0;

		for ( r = 0; r < blocks.length(); r++ ) {

			if ( blocks.charAt(r) == 'W' ) {
				recolor++;
			}

			/**
			 * 1234567
			 *  L     R
			 * WBBWWBBWBW
			 *
			 */

			if ( r - l + 1 == k ) {
				ans = Math.min(ans, recolor);
				if ( blocks.charAt(l) == 'W' ) {
					recolor--;
				}
				l++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.minimumRecolors("WBBWWBBWBW", 7));
	}
}
