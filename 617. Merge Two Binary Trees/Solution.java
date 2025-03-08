class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right= right;
	}
}

public class Solution {

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

		if ( root1 == null && root2 == null ) {
			return null;
		}

		if ( root1 == null ) {
			return root2;
		}

		if ( root2 == null ) {
			return root1;
		}

		TreeNode root = new TreeNode(root1.val + root2.val);
		root.left = mergeTrees(root1.left, root2.left);
		root.right = mergeTrees(root1.right, root2.right);

		return root;
	}

	public static void main(String[] args) {

		TreeNode root1 = new TreeNode(1);
		TreeNode root1_2 = new TreeNode(2);
		TreeNode root1_3 = new TreeNode(3);
		TreeNode root1_5 = new TreeNode(5);

		root1.left = root1_3;
		root1.right = root1_2;
		root1_3.left = root1_5;

		TreeNode root2 = new TreeNode(2);
		TreeNode root2_1 = new TreeNode(1);
		TreeNode root2_3 = new TreeNode(3);
		TreeNode root2_4 = new TreeNode(4);
		TreeNode root2_7 = new TreeNode(7);

		root2.left = root2_1;
		root2.right = root2_3;
		root2_1.right = root2_4;
		root2_3.right = root2_7;

		Solution s = new Solution();
		s.mergeTrees(root1, root2);
	}
}
