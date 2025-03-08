import java.util.ArrayList;
import java.util.List;

public class Solution {

	public boolean isPalindrome(String s) {

		int l = s.length();

		//	0 1 2 3 4 5
		//	a b c c b b
		for ( int i = 0; i < l /2; i++ ) {

			//	0	5
			//	1	4
			//	2	3
			if ( s.charAt(i) != s.charAt(l - i - 1) ) {
				return false;
			}
		}

		return true;
	}

	public List<List<String>> partition(String s) {

		List<List<String>> ans = new ArrayList<>();

		dfs(s, 0, new ArrayList<String>(), ans);

		return ans;
	}

	public void dfs(String s, int here, List<String> list, List<List<String>> ans) {

		int l = s.length();

//		System.out.println();

		if ( s.length() <= here ) {
			ans.add(new ArrayList<>(list));
			return;
		}

		for ( int i = here; i < l; i++ ) {

				String str = s.substring(here, i + 1);

				if ( !isPalindrome(str) ) {
					continue;
				}

				list.add(str);
				dfs(s, i + 1, list, ans);
				list.remove((list.size() - 1));
		}
	}

	public List<List<String>> partition2(String s) {

		//		a b b a
		//		0 1 2 3
		//	0	T
		//	1     T T 0
		//	2	    T F
		//	3         T

		//	1, 3
		//	0, 2

		//	0, 3

		boolean[][] dp = new boolean[s.length()][s.length()];

		List<List<String>> ans = new ArrayList<>();

		List<String> list = new ArrayList<>();

		for ( int i = 0; i < s.length(); i++ ) {
			dp[i][i] = true;
			list.add(s.substring(i, i+1));
		}

		ans.add(list);

		list = new ArrayList<>();

		for ( int i = 0; i < s.length() - 1; i++ ) {

			if ( s.charAt(i) == s.charAt(i + 1) ) {
				dp[i][i+1] = true;
				list.add(s.substring(i, i + 2));
			}
		}

		ans.add(list);

		list = new ArrayList<>();

		int k = 2;
		int x = 0;

		for ( int i = s.length() - 3; i >= 0; i-- ) {

			x = i;

			for ( int j = s.length() - 1; j >= k; j-- ) {

				if ( s.charAt(x) == s.charAt(j) && dp[x+1][j-1] ) {
					dp[x][j] = true;
					list.add(s.substring(x, (j + 1)));
				}
				x--;
			}
			k++;
		}

		if ( !list.isEmpty() ) {
			ans.add(list);
		}

		printArr(dp);

		/*
			  a b c c b b
			a T F F F F F
			b   T F F T F
			c     T T F F
			c       T F F
			b         T T
			b           T
		 */

		return ans;
	}

	public void printArr(boolean[][] arr) {

		for ( int i = 0; i < arr.length; i++ ) {
			for ( int j = 0; j < arr[0].length; j++ ) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		String str = "aab";

//		System.out.println(str.substring(0, 1));
//		System.out.println(str.substring(0, 2));
//		System.out.println(str.substring(0, 3));
//
////		System.out.println(str.substring(1, 1));
//		System.out.println(str.substring(1, 2));
//		System.out.println(str.substring(1, 3));
//
//		System.out.println("=====");
//
//		int l = str.length();
//
//		for ( int i = 0; i < l; i++ ) {
//
//			for ( int j = (i+1); j <= l; j++ ) {
//				System.out.println(str.substring(i, j));
//			}
//		}

		Solution s = new Solution();
		System.out.println(s.partition(str));
	}
}
