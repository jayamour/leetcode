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

	@Override
	public String toString() {
		return "(" + val + ")";
	}
}

public class Solution {

	public boolean evaluateTree(TreeNode root) {

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.push(root);

		Deque<TreeNode> calStack = new ArrayDeque<>();

		while ( !stack.isEmpty() ) {

			TreeNode node = stack.pop();

			calStack.push(node);

			if ( node.left != null && node.right != null ) {
				stack.push(node.right);
				stack.push(node.left);
			}
		}

		Deque<Boolean> evalStack = new ArrayDeque<>();

		while ( !calStack.isEmpty() ) {

			TreeNode node = calStack.pop();

			//	leaf node
			if ( node.left == null && node.right == null ) {
				evalStack.push(node.val == 1);
			} else {

				boolean rightEval = evalStack.pop();
				boolean leftEval = evalStack.pop();

				boolean result;

				if ( node.val == 2 ) {
					result = leftEval || rightEval;
				} else {
					result = leftEval && rightEval;
				}

				evalStack.push(result);
			}
		}

		return evalStack.pop();
	}

	public static void main(String[] args) {

		Solution solution = new Solution();
		TreeNode root = new TreeNode(2
				, new TreeNode(1)
				, new TreeNode(3, new TreeNode(0), new TreeNode(1)));

		System.out.println(solution.evaluateTree(root));
	}
}
