import java.util.LinkedList;
import java.util.Queue;

class Pair {

	int withRoot;
	int wihoutRoot;

	public Pair() {};

	public Pair(int wR, int woR) {
		this.withRoot = wR;
		this.wihoutRoot = woR;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	Pair pair;

	TreeNode () {};

	TreeNode(int val) {
		this.val = val;
		pair = new Pair();
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution {
	public Pair dfs(TreeNode root) {

		if ( root == null ) {
			return new Pair(0, 0);
		}

		Pair pairLeft = dfs(root.left);
		Pair pairRight = dfs(root.right);

		int withRoot = root.val + pairLeft.wihoutRoot + pairRight.wihoutRoot;
		int withoutRoot
				= Math.max(pairLeft.withRoot, pairLeft.wihoutRoot) + Math.max(pairRight.withRoot, pairRight.wihoutRoot);

		return new Pair(withRoot, withoutRoot);
	}

	public int rob(TreeNode root) {

		Pair result = this.dfs(root);

		return Math.max(result.withRoot, result.wihoutRoot);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
