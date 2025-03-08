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

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);

		while ( !stack.isEmpty() ) {

			TreeNode node = stack.pop();

			if ( node.val == subRoot.val ) {
				if ( isSameTree(node, subRoot) ) {
					return true;
				}
			}

			if ( node.right != null ) {
				stack.push(node.right);
			}

			if ( node.left != null ) {
				stack.push(node.left);
			}
		}

		return false;
	}

	private boolean isSameTree(TreeNode root, TreeNode subRoot) {

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);

		Deque<TreeNode> sub = new ArrayDeque<>();
		sub.push(subRoot);

		while ( !stack.isEmpty() ) {

			TreeNode node = stack.pop();
			TreeNode subNode = sub.pop();

			if ( node.val != subNode.val ) {
				return false;
			}

			if ( node.right != null && subNode.right == null ) {
				return false;
			}

			if ( node.right == null && subNode.right != null ) {
				return false;
			}

			if ( node.right != null ) {
				stack.push(node.right);
				sub.push(subNode.right);
			}

			if ( node.left != null && subNode.left == null ) {
				return false;
			}

			if ( node.left == null && subNode.left != null ) {
				return false;
			}

			if ( node.left != null ) {
				stack.push(node.left);
				sub.push(subNode.left);
			}
		}

		return true;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();

		TreeNode root = new TreeNode(3
				, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null))
				, new TreeNode(5));

		TreeNode subTree = new TreeNode(4, new TreeNode(1), new TreeNode(2));

		System.out.println(solution.isSubtree(root, subTree));
	}
}
