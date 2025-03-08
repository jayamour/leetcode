import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {

		boolean[] visited = new boolean[rooms.size()];

		dfs(0, visited, rooms);

		for ( boolean b : visited ) {

			if ( !b ) {
				return false;
			}
		}

		return true;
	}

	private void dfs(int start, boolean[] visited, List<List<Integer>> rooms) {

		Stack<Integer> stack = new Stack<>();
		stack.push(start);

		while (!stack.isEmpty()) {

			int current = stack.pop();

			if ( !visited[current] ) {
				visited[current] = true;

				for ( int next : rooms.get(current) ) {
					stack.push(next);
				}
			}
		}
	}

	public static void main(String[] args) {

		List<List<Integer>> rooms = new ArrayList<>();

		for ( int i = 0; i < 4; i++ ) {
			rooms.add(new ArrayList<Integer>());
		}

		rooms.get(0).add(1);
		rooms.get(0).add(3);

		rooms.get(1).add(3);
		rooms.get(1).add(0);
		rooms.get(1).add(1);

		rooms.get(2).add(2);

		rooms.get(3).add(0);

		Solution solution = new Solution();
		System.out.println(solution.canVisitAllRooms(rooms));
	}
}
