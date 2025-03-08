class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) {
		this.val = x;
	}
}

public class Solution {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		//	100,000
		//	131,072
		System.out.println(Math.pow(2.0, 17));

		System.out.println(dfs(root, 0));

		return null;
	}

	public int dfs(TreeNode root, int depth) {

		if ( root == null ) {
			return 0;
		}

		System.out.println(root.val);

		int left = dfs(root.left, depth + 1);
		int right = dfs(root.right, depth + 1);

		System.out.println("left: " + left + ", right: " + right);

		return 1 + left + right;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode zero = new TreeNode(0);
		TreeNode four = new TreeNode(4);
		TreeNode three = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode eight = new TreeNode(8);
		TreeNode seven = new TreeNode(7);
		TreeNode nine = new TreeNode(9);

		root.left = two;
		two.left = zero;
		two.right = four;
		four.left = three;
		four.right = five;

		root.right = eight;
		eight.left = seven;
		eight.right = nine;

		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(8);

		Solution s = new Solution();
		System.out.println(s.lowestCommonAncestor(root, p, q));
	}
}
