
public class Solution {

	public int numberOfAlternatingGroups(int[] colors, int k) {

		int n = colors.length;
		int[] extended = new int[n * 2];

		for ( int i = 0; i < n * 2; i++ ) {
			extended[i] = colors[i % n];
		}

		int count = 0; // 교대 그룹 개수를 세기 위한 변수
		int samePairs = 0;
		
		for ( int i = 0; i < k - 1; i++ ) {
			if ( extended[i] == extended[i + 1] ) {
				samePairs++;
			}
		}

		if ( samePairs == 0 ) {
			count++;
		}

		for ( int i = 1; i < n; i++ ) {

			if ( extended[i-1] == extended[i] ) {
				samePairs--;
			}

			if ( extended[i + k - 2] == extended[i + k - 1] ) {
				samePairs++;
			}

			if ( samePairs == 0 ) {
				count++;
			}
		}

		//	sliding window
		//	out: 0, in: 4
		//	out: 1, in: 5
		//	out: 2, in: 6
		/**
		 * 0 1 2 3 4 5 | 6 7 8
		 * 0 0 1 0 1 1 | 0 0 1
		 * x x x x
		 *   x x x x
		 *     x x x x
		 */

		return count;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numberOfAlternatingGroups(new int[]{0, 0, 1, 0, 1, 1}, 4));
//		System.out.println(s.numberOfAlternatingGroups(new int[]{0, 0, 0}, 3));
//		System.out.println(s.numberOfAlternatingGroups(new int[]{0, 1, 0, 1}, 3));
//		System.out.println(s.numberOfAlternatingGroups(new int[]{0, 1, 0, 1}, 4));
//		System.out.println(s.numberOfAlternatingGroups(new int[]{0, 0, 1, 1}, 3));
//		System.out.println(s.numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1, 0, 1}, 6));
//		System.out.println(s.numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1, 0, 1, 1, 0, 0}, 3));
//		System.out.println(s.numberOfAlternatingGroups(new int[] { 0, 1, 0, 1, 0 }, 3));
	}
}
