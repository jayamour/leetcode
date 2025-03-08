import java.util.HashMap;
import java.util.Set;

public class Solution {

	public int firstUniqChar(String s) {

		int length = s.length();

		HashMap<Character, Integer> map = new HashMap<>();
		int [] idx = new int[27];

		char a = 97;

		char c;

		for ( int i = 0; i < length; i++ ) {

			c = s.charAt(i);

			map.merge(c, 1, Integer::sum);

			if ( idx[c - a + 1] == 0 ) {
				idx[c - a + 1] = i;
			}
		}

		map.forEach((key, value) -> {
			System.out.println(key + ": " + value);
		});

		boolean found = false;

		int res = Integer.MAX_VALUE;

		//	loveleetcode
		Set<Character> set = map.keySet();

		for ( Character ch : set ) {

			if ( map.get(ch) == 1 ) {
				System.out.println("ch = " + ch);
				found = true;

				res = Math.min(idx[ch - a + 1], res);
			}
		}

		if ( !found ) {
			return -1;
		}

		return res;
	}

	public static void main(String[] args) {

		String str
				= "itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb";
//		String str = "aabb";

		Solution s = new Solution();
		System.out.println(s.firstUniqChar(str));
	}
}
