import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

	private static Map<Character, int[]> map = new HashMap<>();

	public String alphabetBoardPath(String target) {

		for ( int i = 97; i <= 122; i++ ) {
			map.put((char)i, new int[]{((i - 97) / 5), (i - 97) % 5});
		}

		map.forEach((key, value) -> {
			int[] v = map.get(key);
		});

		StringBuilder sb = new StringBuilder();

		int[] bf = new int[]{0, 0};

		for ( int i = 0; i < target.length(); i++ ) {
			Character c = target.charAt(i);

			int[] v = map.get(c);

			int ud = v[0] - bf[0];
			int lf = v[1] - bf[1];

			if ( bf[0] == 5 && bf[1] == 0 ) {

				if ( ud >= 0 ) {
					for ( int j = 0; j < ud; j++ ) {
						sb.append("D");
					}
				} else {
					for ( int j = 0; j < ud * (-1); j++ ) {
						sb.append("U");
					}
				}

				if ( lf >= 0 ) {
					for ( int j = 0; j < lf; j++ ) {
						sb.append("R");
					}
				} else {
					for ( int j = 0; j < lf * (-1); j++ ) {
						sb.append("L");
					}
				}
			} else {

				if ( lf >= 0 ) {
					for ( int j = 0; j < lf; j++ ) {
						sb.append("R");
					}
				} else {
					for ( int j = 0; j < lf * (-1); j++ ) {
						sb.append("L");
					}
				}

				if ( ud >= 0 ) {
					for ( int j = 0; j < ud; j++ ) {
						sb.append("D");
					}
				} else {
					for ( int j = 0; j < ud * (-1); j++ ) {
						sb.append("U");
					}
				}
			}

			sb.append("!");
			bf = v;
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String target = "xyzn";
		System.out.println(solution.alphabetBoardPath(target));
	}
}
