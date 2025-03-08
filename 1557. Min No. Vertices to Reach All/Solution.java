import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

		int[] inCount = new int[n];
		int[] outCount = new int[n];

		for ( List<Integer> e : edges ) {
			outCount[e.get(0)]++;
			inCount[e.get(1)]++;
		}

		List<Integer> answer = new ArrayList<>();

		for ( int i = 0; i < n; i++ ) {
			if ( inCount[i] == 0 ) {
				answer.add(i);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		List<List<Integer>> edges = new ArrayList<>();

		List<Integer> edge1 = List.of(0, 1);
		List<Integer> edge2 = List.of(0, 2);
		List<Integer> edge3 = List.of(2, 5);
		List<Integer> edge4 = List.of(3, 4);
		List<Integer> edge5 = List.of(4, 2);

		edges.add(edge1);
		edges.add(edge2);
		edges.add(edge3);
		edges.add(edge4);
		edges.add(edge5);

		System.out.println(s.findSmallestSetOfVertices(6, edges));
	}
}
