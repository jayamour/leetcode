import java.util.*;

public class Solution {

	static class Edge {
		String to;
		double value;

		public Edge(String to, double value) {
			this.to = to;
			this.value = value;
		}
	}

	private void addEdge(Map<String, List<Edge>> map, String from, String to, double value) {

		if ( !map.containsKey(from) ) {
			map.put(from, new ArrayList<>());
		}

		map.get(from).add(new Edge(to, value));
	}

	private double dfs(Map<String, List<Edge>> map, Set<String> visited, String from, String to) {

		if ( !map.containsKey(from) ) {
			return -1.0;
		}

		if ( from.equals(to) ) {
			return 1.0;
		}

		visited.add(from);

		for ( Edge edge : map.get(from) ) {
			if ( !visited.contains(edge.to) ) {

				double result = dfs(map, visited, edge.to, to);

				if ( result != -1.0 ) {
					return result * edge.value;
				}
			}
		}

		return -1.0;
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

		Map<String, List<Edge>> map = new HashMap<>();

		for ( int i = 0; i < values.length; i++ ) {
			List<String> eq = equations.get(i);
			addEdge(map, eq.get(0), eq.get(1), values[i]);
			addEdge(map, eq.get(1), eq.get(0), 1 / values[i]);
		}

		double[] answer = new double[queries.size()];

		for ( int i = 0; i < answer.length; i++ ) {
			List<String> q = queries.get(i);
			answer[i] = dfs(map, new HashSet<>(), q.get(0), q.get(1));
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		List<List<String>> equations = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");

		List<String> list2 = new ArrayList<>();
		list2.add("b");
		list2.add("c");

		equations.add(list1);
		equations.add(list2);

		for ( List<String> equation : equations ) {
			System.out.println(equation);
		}
	}
}
