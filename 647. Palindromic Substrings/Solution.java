public class Solution {

	public int countSubstrings(String s) {

		int res = 0;

		boolean [][] dp = new boolean[s.length()][s.length()];

		for ( int i = 0; i < s.length(); i++ ) {
			dp[i][i] = true;
			res++;
		}

		for ( int i = 0; i < s.length()-1; i++ ) {

			if ( s.charAt(i) == s.charAt(i+1) ) {
				dp[i][i+1] = true;
				res++;
			} else {
				dp[i][i+1] = false;
			}
		}

		int k = 2;
		int x = 0;

		for ( int i = s.length() - 3; i >= 0; i-- ) {

			x = i;

			/*
			3, 5
			2, 4
			1, 3
			0, 2

			2, 5
			1, 4
			0, 3

			1, 5
			0, 4

			0, 5
			 */
			/*
				  a b c c b b
				a T F F F F F
				b   T F F T F
				c     T T F F
				c       T F F
				b         T T
				b           T
			 */
			for ( int j = s.length()-1; j >= k; j-- ) {

				if ( (s.charAt(x) == s.charAt(j)) && dp[x+1][j-1] ) {
					dp[x][j] = true;
					res++;
				}

				x--;
			}
			k++;
		}

//		print(dp);

		return res;
	}

	public void print(boolean [][] arr) {
		for ( int i = 0; i < arr.length; i++ ) {

			for ( int j = 0; j < arr[0].length; j++ ) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		String str = "abccbb";
		Solution s = new Solution();
		System.out.println(s.countSubstrings(str));
	}
}
