public class Solution {

	public int findJudge(int n, int[][] trust) {

		if ( trust.length == 0 ) {
			return 1;
		}

		int[] in = new int[n+1];
		int[] out = new int[n+1];

		for ( int i = 0; i < trust.length; i++ ) {
			out[trust[i][0]]++;
			in[trust[i][1]]++;
		}

		for ( int i = 1; i <= n; i++ ) {
			if ( in[i] == n-1 && out[i] == 0 ) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findJudge(3, new int[][] { { 1, 3 }, { 2, 3 } }));
	}
}
