import java.util.HashMap;

public class Solution {

	public boolean checkInclusion(String s1, String s2) {

		int s1l = s1.length();
		int s2l = s2.length();

		HashMap<Character, Integer> s1Map = new HashMap<>();
		HashMap<Character, Integer> s2Map = new HashMap<>();

		for ( int i = 97; i <= 122; i++ ) {
			char c = (char) i;
			s1Map.merge(c, 0, Integer::sum);
			s2Map.merge(c, 0, Integer::sum);
		}

//		for ( int i = 0; i < s1l; i++ ) {
//			char c = s1.charAt(i);
//			s1Map.merge(c, 1, Integer::sum);
//		}

		for ( int i = 0; i < s1l; i++ ) {
			char c = s1.charAt(i);
			s1Map.merge(c, 1, Integer::sum);
		}

		for ( int i = 0; i < s1l; i++ ) {
			char c = s2.charAt(i);
			s2Map.merge(c, 1, Integer::sum);
		}

//		s1Map.forEach((key, value) -> {
//			System.out.println(key + ": " + value);
//		});
//
//		s2Map.forEach((key, value) -> {
//			System.out.println(key + ": " + value);
//		});


		int cnt = 26;

		int k = 0;

		for ( int i = 0; i < s1l; i++ ) {
			char c = s2.charAt(i);

			if ( s1Map.get(c) != s2Map.get(c) ) {
				k++;
			}
		}

//		String s1 = "ab";
//		String s2 = "eidboaoo";

		cnt -= k;
		
		if ( cnt == 26 ) {
			return true;
		}

		System.out.println("cnt = " + cnt);

		int origin = cnt;

		//	abc : 3
		//	01234567
		//	baxdacboo : 9
		//	012
		//	 123
		//	  234
		//	   345
		//		456
		//		 567



		//	adc : 3
		//	01234567
		//	dcda : 4
		//	012
		//	 123
		//	  234
		//	   345
		//		456
		//		 567
		for ( int i = s1l; i < s2l; i++ ) {

			int l = i - s1l;

			//	out
			char left = s2.charAt(l);
//			System.out.println("left = " + left);

			if ( s2Map.get(left) == null ) {
				s2Map.putIfAbsent(left, 0);
			} else if ( s2Map.get(left) > 0 ) {
				s2Map.put(left, s2Map.get(left) - 1);
			} else {
				s2Map.put(left, 0);
			}

			if ( s1Map.putIfAbsent(left, 0) != s2Map.get(left) ) {
				cnt--;
			} else {
				cnt++;
			}

//			s2Map.forEach((key, value) -> {
//				System.out.println(key + ": " + value);
//			});
//
//			System.out.println("cnt = " + cnt);

			//	in
			char right = s2.charAt(i);
//			System.out.println("right = " + right);

			if ( s2Map.get(right) == null ) {
				s2Map.put(right, 1);
			} else {
				s2Map.put(right, s2Map.get(right) + 1);
			}

			if ( s1Map.putIfAbsent(right, 0) == s2Map.get(right) ) {
				cnt++;
			} else {
				cnt--;
			}

//			s2Map.forEach((key, value) -> {
//				System.out.println(key + ": " + value);
//			});
//			System.out.println("cnt => " + cnt);

			if ( s1Map.equals(s2Map) ) {
				return true;
			}

//			if ( cnt == 26 ) {
//				return true;
//			}
		}

		return false;
	}

	public static void main(String[] args) {

		String s1 = "ab";
		String s2 = "eidboaoo";
//		String s1 = "a";
//		String s2 = "ab";

		Solution s = new Solution();
		System.out.println(s.checkInclusion(s1, s2));
	}
}
