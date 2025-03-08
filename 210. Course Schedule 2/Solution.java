import java.util.*;

public class Solution {

	public int[] findOrder(int numCourses, int[][] prerequisites) {

		List<List<Integer>> list = new ArrayList<>();

		for ( int i = 0; i < numCourses; i++ ) {
			list.add(new ArrayList<>());
		}

		for ( int i = 0; i < prerequisites.length; i++ ) {
			int[] row = prerequisites[i];
			list.get(row[1]).add(row[0]);
		}

		int[] inDegree = new int[numCourses];

		for ( int i = 0; i < numCourses; i++ ) {

			for ( int to : list.get(i) ) {
				inDegree[to]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();

		for ( int i = 0; i < numCourses; i++ ) {
			if ( inDegree[i] == 0 ) {
				q.add(i);
			}
		}

		int[] res = new int[numCourses];
		int idx = 0;

		while ( !q.isEmpty() ) {

			int from = q.poll();
			res[idx++] = from;

			for ( int next : list.get(from) ) {
				inDegree[next]--;

				if ( inDegree[next] == 0 ) {
					q.offer(next);
				}
			}
		}

		if ( idx == numCourses ) {
			return res;
		}

		int[] emptyArr = {};

		return emptyArr;
	}

	public static void main(String[] args) {

		int numCourses = 4;
		int[][] p = {{1,0}, {2,0}, {3,1}, {3,2}};
//		int[][] p = {{0,1}, {1,0}};

		Solution s = new Solution();
		s.findOrder(numCourses, p);
	}
}
