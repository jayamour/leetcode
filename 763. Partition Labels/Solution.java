import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public List<Integer> partitionLabels(String s) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map.put(ch, i);
		}

		List<Integer> ans = new ArrayList<>();

		int start = 0, end = 0;

		for ( int i = 0; i < s.length(); i++ ) {

			char ch = s.charAt(i);

			end = Math.max(end, map.get(ch));

			if ( i == end ) {

				ans.add(i - start + 1);
				start = i + 1;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));
	}
}
