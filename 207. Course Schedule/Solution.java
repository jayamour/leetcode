import java.util.*;

public class Solution {

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		Map<Integer, List<Integer>> graph = new HashMap<>();

		//	0: not visited yet
		//	1: visiting
		//	2: visited
		int[] visited = new int[numCourses];

		for ( int[] p : prerequisites ) {
			graph.putIfAbsent(p[1], new ArrayList<>());
			graph.get(p[1]).add(p[0]);
		}

		for ( int i : graph.keySet() ) {
			if ( visited[i] == 0 ) {
				if ( dfs(i, graph, visited) ) return false;
			}
		}

		return true;
	}

	private boolean dfs(int i, Map<Integer, List<Integer>> graph, int[] visited) {

		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(i);

		while ( !stack.isEmpty() ) {

			int node = stack.pop();

			if ( visited[node] == 0 ) {

				visited[node] = 1;	//	visiting
				stack.push(node);	//	pushing curr node to stack

				for ( int to : graph.getOrDefault(node, new ArrayList<>()) ) {

					if ( visited[to] == 0 ) {
						stack.push(to);
					} else if ( visited[to] == 1 ) {
						return true;
					}
				}
			} else if ( visited[node] == 1 ){
//				stack.pop();
				visited[node] = 2;	//	visited
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
	}
}
