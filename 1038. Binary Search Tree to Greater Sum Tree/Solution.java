import java.util.ArrayDeque;
import java.util.Deque;

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

	public TreeNode bstToGst(TreeNode root) {

		Deque<TreeNode> stack = new ArrayDeque<>();

		TreeNode cur = root;
		TreeNode prev = null;

		while ( cur != null || !stack.isEmpty() ) {

			while ( cur != null ) {
				stack.push(cur);
				cur = cur.right;
			}

			cur = stack.pop();

			if (prev != null) {
				cur.val += prev.val;
			}


			prev = cur;
			cur = cur.left;
		}

		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4
				, new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3)))
				, new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));

		Solution solution = new Solution();
		solution.bstToGst(root);
	}
}
