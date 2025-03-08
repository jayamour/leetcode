import java.util.*;

public class Solution {
	public List<Integer> findAnagrams(String s, String p) {

		if ( s.length() < p.length() ) {
			return null;
		}

		List<Integer> ans = new ArrayList<>();

		HashMap<Character, Integer> param = new HashMap<>();

		for ( int i = 0; i < p.length(); i++ ) {

			char c = p.charAt(i);
			param.merge(c, 1, Integer::sum);
		}

		int l = 0;
		int r = p.length();

		HashMap<Character, Integer> str = new HashMap<>();

		for ( int i = 0; i < p.length(); i++ ) {
			char c = s.charAt(i);
			str.merge(c, 1, Integer::sum);
		}

		String first = s.substring(l, r);

		if ( isMapSame(str, param) ) {
			ans.add(l);
		}

		//	l = 0, r = 3
		for ( int i = r; i < s.length(); i++ ) {

			char left = s.charAt(l);

			if ( str.get(left) != null ) {

				if ( str.get(left) == 1 ) {
					str.remove(left);
				} else {
					str.put(left, str.get(left) - 1);
				}
			}

			char right = s.charAt(i);

			str.merge(right, 1, Integer::sum);

			if ( isMapSame(str, param) ) {
				ans.add(l+1);
			}

			l++;
		}

		return ans;
	}

	public boolean isMapSame(HashMap<Character, Integer> str, HashMap<Character, Integer> param) {

		for ( char c : str.keySet() ) {
			if (!Objects.equals(str.get(c), param.get(c))) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		String str = "abab";
		String p = "ab";

		Solution s = new Solution();
		System.out.println(s.findAnagrams(str, p));
	}
}