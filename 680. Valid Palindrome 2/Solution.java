public class Solution {

	public boolean validPalindrome(String s) {

		int len = s.length();

		int cnt = 0;

		int l = 0;
		int r = len - 1;

		while (l < r) {

			if ( s.charAt(l) != s.charAt(r)) {
				return isPalindrome(s, l, r-1) || isPalindrome(s, l+1, r);
			}

			l++;
			r--;
		}

		return true;
	}

	public boolean isPalindrome(String s, int l, int r) {

		while (l < r) {

			if ( s.charAt(l++) != s.charAt(r--) ) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		Solution s = new Solution();
		System.out.println(s.validPalindrome("ebcbbececabbacecbbcbe"));
//		System.out.println(s.validPalindrome("abcfeefxba"));
//		System.out.println(s.validPalindrome("abbe"));	//	false
		//	0 1 2 3
		//	a b b e
		//	  l   r
		//	l   r
	}
}
