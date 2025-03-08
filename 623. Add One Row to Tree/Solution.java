import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
}

public class Solution {

	public TreeNode addOneRow(TreeNode root, int val, int depth) {

		if ( depth == 1 ) {
			TreeNode newRoot = new TreeNode(val);
			newRoot.left = root;
			return newRoot;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int d = 1;

		while ( !queue.isEmpty() ) {

			int size = queue.size();

			for ( int i = 0; i < size; i++ ) {

				TreeNode node = queue.poll();

				if ( (depth - 1) == d ) {

					TreeNode leftChild = new TreeNode(val);
					leftChild.left = node.left;
					node.left = leftChild;

					TreeNode rightChild = new TreeNode(val);
					rightChild.right = node.right;
					node.right = rightChild;

				} else {

					if ( node.left != null ) {
						queue.add(node.left);
					}

					if ( node.right != null ) {
						queue.add(node.right);
					}
				}
			}

			d++;
		}

		queue.add(root);

		while ( !queue.isEmpty() ) {
			TreeNode node = queue.poll();
			System.out.println(node.val);
			if ( node.left != null ) {
				queue.add(node.left);
			}

			if ( node.right != null ) {
				queue.add(node.right);
			}
		}

		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4
				, new TreeNode(2, new TreeNode(3), new TreeNode(1))
				, new TreeNode(6, new TreeNode(5), null));

		Solution s = new Solution();
		s.addOneRow(root, 1, 2);
	}
}
