import java.util.Stack;

public class Solution {

	static class Pair {
		int temp;
		int idx;

		Pair(int temp, int idx) {
			this.temp = temp;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return temp + ", " + idx;
		}
	}

	public int[] dailyTemperatures(int[] temperatures) {

		int len = temperatures.length;

		int [] res = new int[len];

		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(temperatures[0], 0));

		Pair p;

		for ( int i = 1; i < len; i++ ) {

			p = stack.peek();

			if ( p.temp < temperatures[i] ) {
				res[p.idx] = i - p.idx;
				stack.pop();
			}

			//	71
			while ( !stack.isEmpty() ) {

				p = stack.peek();

				//		71 < 72
				if ( p.temp < temperatures[i] ) {
					res[p.idx] = i-p.idx;
					stack.pop();
				} else {
					break;
				}
			}

			stack.push(new Pair(temperatures[i], i));
		}

//		for ( int i = 0; i < len; i++ ) {
//			System.out.print(res[i] + " ");
//		}
//		System.out.println();

		return res;
	}

	public int[] dailyTemperatures2(int[] temperatures) {

		int len = temperatures.length;

		int[] res = new int[len];

		int[][] dp = new int[len][len];

		int diff = 0;

		boolean check = false;

		for (int j = 1; j < len; j++) {
			dp[0][j] = temperatures[j] - temperatures[0];

			if (dp[0][j] > 0 && !check) {
				res[0] = j;
				check = true;
			}
		}

		boolean found = false;

		for (int i = 1; i < len; i++) {

			found = false;

			for (int j = (i + 1); j <= len - 1; j++) {

				diff = temperatures[i - 1] - temperatures[i];
				dp[i][j] = dp[i - 1][j] + diff;

				if ( dp[i][j] > 0 && !found ) {
					res[i] = j-i;
					found = true;
				}
			}
		}

		print(dp);
//		System.out.println("======");
//		for ( int i = 0; i < len; i++ ) {
//			System.out.print(res[i] + " ");
//		}
//		System.out.println();

		return res;
	}

	public void print(int[][] dp) {

		for ( int i = 0; i < dp.length; i++ ) {
			for ( int j = 1; j < dp[i].length; j++ ) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int [] t = {73,74,75,71,69,72,76,73};
//		int [] t = {89,62,70,58,47,47,46,76,100,70};

		Solution s = new Solution();
		s.dailyTemperatures(t);
	}
}
