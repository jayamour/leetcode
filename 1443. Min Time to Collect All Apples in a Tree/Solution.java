import java.util.*;

public class Solution {

	Map<Integer, List<Integer>> tree;

	private static class State {

		int node;        //	current node
		int parent;        //	parent node
		int index;        //
		boolean foundApple;

		State(int node, int parent, int index, boolean foundApple) {
			this.node = node;
			this.parent = parent;
			this.index = index;
			this.foundApple = foundApple;
		}
	}

	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

		tree = new HashMap<>();

		for ( int i = 0; i < edges.length; i++ ) {
			tree.putIfAbsent(edges[i][0], new ArrayList<>());
			tree.get(edges[i][0]).add(edges[i][1]);

			tree.putIfAbsent(edges[i][1], new ArrayList<>());
			tree.get(edges[i][1]).add(edges[i][0]);
		}

		int cost = 0;

		Deque<State> stack = new ArrayDeque<>();

		stack.push(new State(0, -1, 0, hasApple.get(0)));

		while ( !stack.isEmpty() ) {
			//	현재 처리 중인 노드
			State curr = stack.peek();
			List<Integer> children = tree.get(curr.node);

			//	still has children to process ...
			if ( curr.index < children.size() ) {

				int child = children.get(curr.index);
				curr.index++;

				if ( child == curr.parent ) {
					continue;
				}

				stack.push(new State(child, curr.node, 0, hasApple.get(child)));
			} else {
				//	process finished: current node
				State finished = stack.pop();

				//	check if current node has parent to process
				if ( !stack.isEmpty() ) {

					//	check if subtree of current node has apples
					if ( finished.foundApple ) {
						cost += 2;
						stack.peek().foundApple = true;
					}
				}
			}
		}

		return cost;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
		int n = 7;

		List<Boolean> hasApple = new ArrayList<>();
		hasApple.add(false);
		hasApple.add(false);
		hasApple.add(true);
		hasApple.add(false);
		hasApple.add(true);
		hasApple.add(true);
		hasApple.add(false);

		System.out.println(solution.minTime(n, edges, hasApple));
	}
}
