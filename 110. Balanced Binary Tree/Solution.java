import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "(" + val + ")";
	}
}

public class Solution {

	static class Pair {

		static enum State {
			FIRST, LEFT, RIGHT, CALCULATED
		}

		TreeNode node;
		State state;

		public Pair(TreeNode node, State state) {
			this.node = node;
			this.state = state;
		}
	}

	public boolean isBalanced(TreeNode root) {

		Deque<Pair> stack = new ArrayDeque<>();
		stack.offer(new Pair(root, Pair.State.FIRST));

		Map<TreeNode, Integer> depthMap = new HashMap<>();
		depthMap.put(null, 0);

		while ( !stack.isEmpty() ) {

			Pair p = stack.peek();

			if ( p.state == Pair.State.FIRST ) {
				if ( p.node.left != null ) {
					stack.push(new Pair(p.node.left, Pair.State.FIRST));
				}
				p.state = Pair.State.LEFT;
			} else if ( p.state == Pair.State.LEFT ) {
				if ( p.node.right != null ) {
					stack.push(new Pair(p.node.right, Pair.State.FIRST));
				}
				p.state = Pair.State.RIGHT;
			} else if ( p.state == Pair.State.RIGHT ) {

				int leftDepth = depthMap.get(p.node.left);
				int rightDepth = depthMap.get(p.node.right);

				if ( Math.abs(leftDepth - rightDepth) > 1 ) {
					return false;
				}

				depthMap.put(p.node, Math.max(leftDepth, rightDepth) + 1);
				p.state = Pair.State.CALCULATED;
				System.out.println("p.node.val = " + p.node.val);
				stack.pop();
			}
		}

		return true;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();

//		TreeNode root = new TreeNode(1);

		TreeNode root = new TreeNode(3
				, new TreeNode(9)
				, new TreeNode(20, new TreeNode(15), new TreeNode(7)));

		System.out.println(solution.isBalanced(root));
	}
}
