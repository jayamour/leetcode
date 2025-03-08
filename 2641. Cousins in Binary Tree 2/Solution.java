import java.util.ArrayDeque;
import java.util.Deque;

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
}

public class Solution {

	static class NodeInfo {
		int brother;
		TreeNode node;

		public NodeInfo(int brother, TreeNode node) {
			this.brother = brother;
			this.node = node;
		}
	}

	public TreeNode replaceValueInTree(TreeNode root) {

		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);

		Deque<NodeInfo> brother = new ArrayDeque<>();

		while ( !queue.isEmpty() ) {

			int size = queue.size();
			int sum = 0;

			brother.clear();

			for ( int i = 0; i < size; i++ ) {

				TreeNode node = queue.poll();

				if ( node.left != null ) {
					queue.add(node.left);
					sum += node.left.val;

					if ( node.right != null ) {
						brother.add(new NodeInfo(node.right.val, node.left));
					} else {
						brother.add(new NodeInfo(0, node.left));
					}
				}

				if ( node.right != null ) {
					queue.add(node.right);
					sum += node.right.val;

					if ( node.left != null ) {
						brother.add(new NodeInfo(node.left.val, node.right));
					} else {
						brother.add(new NodeInfo(0, node.right));
					}
				}
			}

			while ( !brother.isEmpty() ) {
				NodeInfo ni = brother.poll();
				TreeNode node = ni.node;

				node.val = sum - ni.brother - node.val;
			}
		}

		root.val = 0;

		return root;
	}

	public static void main(String[] args) {

		Solution s = new Solution();

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4, new TreeNode(1), new TreeNode(10));
		root.right = new TreeNode(9, null, new TreeNode(7));

		s.replaceValueInTree(root);
	}
}
