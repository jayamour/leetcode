class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode() {}
	TreeNode(int val) {
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution {

	public TreeNode deleteNode(TreeNode root, int key) {
		if ( root == null ) {
			return null;
		}

		/*
					70
				30		100
			      40	80	90
			    31  50
			      41  55
		 */

		if ( root.val < key ) {
			root.right = deleteNode(root.right, key);
		} else if ( key < root.val ) {
			root.left = deleteNode(root.left, key);
		} else {

			if ( root.left == null ) return root.right;
			if ( root.right == null ) return root.left;

			root.val = findMin(root.right);

			root.right = deleteNode(root.right, root.val);
		}
		return root;
	}

	public int findMin(TreeNode node) {

		int min = node.val;

		while ( node.left != null ) {

			min = node.left.val;
			node = node.left;
		}

		return min;
	}

	public void dfs(TreeNode root) {

		if ( root == null ) {
			return;
		}
		System.out.println(root.val);

		dfs(root.left);

		dfs(root.right);

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(70);
		TreeNode thirty = new TreeNode(30);
		TreeNode hundred = new TreeNode(100);
		TreeNode ninety = new TreeNode(90);
		TreeNode eighty = new TreeNode(80);
		TreeNode fourty = new TreeNode(40);
		TreeNode fourtyOne = new TreeNode(41);
		TreeNode thirtyOne = new TreeNode(31);
		TreeNode fifty = new TreeNode(50);
		TreeNode fiftyFive = new TreeNode(55);

		root.left = thirty;
		thirty.right = fourty;
		fourty.left = thirtyOne;
		fourty.right = fifty;
		fifty.left = fourtyOne;
		fifty.right = fiftyFive;

		root.right = hundred;
		hundred.left = eighty;
		hundred.right = ninety;

		int k = 40;

		Solution s = new Solution();
		s.deleteNode(root, k);

	}
}
