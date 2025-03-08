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

	TreeNode(int x, TreeNode left, TreeNode right) {
		this.val = x;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "[val=" + val + "]";
	}
}

public class Solution {

	static class NodeInfo {
		TreeNode node;
		boolean visited;

		public NodeInfo(TreeNode root, boolean visited) {
			this.node = root;
			this.visited = visited;
		}

		@Override
		public String toString() {
			return "[node=" + node.val + ", " + visited + "]";
		}
	}

	public int averageOfSubtree(TreeNode root) {

//		Deque<TreeNode> stack = new ArrayDeque<>();
//		stack.push(root);

		Deque<NodeInfo> stack = new ArrayDeque<>();
		stack.push(new NodeInfo(root, false));

		Map<TreeNode, int[]> map = new HashMap<>();

		int answer = 0;

		while ( !stack.isEmpty() ) {

			System.out.println(stack);

			NodeInfo cur = stack.pop();
			TreeNode node = cur.node;

			if ( !cur.visited ) {

				stack.push(new NodeInfo(node, true));

				if ( node.right != null ) {
					stack.push(new NodeInfo(node.right, false));
				}

				if ( node.left != null ) {
					stack.push(new NodeInfo(node.left, false));
				}
			} else {

				//	current node has no child.
				if ( node.left == null && node.right == null ) {
					map.put(node, new int[] { node.val, 1 });
					answer++;
					continue;
				}

				int leftSum = 0, leftCount = 0;

				if ( node.left != null ) {
					leftSum = map.get(node.left)[0];
					leftCount = map.get(node.left)[1];
				}

				int rightSum = 0, rightCount = 0;

				if ( node.right != null ) {
					rightSum = map.get(node.right)[0];
					rightCount = map.get(node.right)[1];
				}

				int sum = leftSum + rightSum + node.val;
				int count = leftCount + rightCount + 1;

				map.put(node, new int[] { sum, count });

				if ( node.val == sum / count ) {
					answer++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {

		Solution s = new Solution();

		TreeNode root = new TreeNode(4
				, new TreeNode(8
				, new TreeNode(0), new TreeNode(1))
				, new TreeNode(5
				, null, new TreeNode(6)));

		System.out.println(s.averageOfSubtree(root));
	}
}
