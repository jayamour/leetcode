class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int x) { val = x; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution {

	TreeNode prev = null;

	public void flatten(TreeNode root) {
		
		if ( root == null ) return;
		
		flatten(root.right);
		flatten(root.left);

		root.right = prev;
		root.left = null;
		prev = root;
	}

	private void printDfs(TreeNode root) {
		if ( root == null ) return;
		System.out.println(root.val);
//		printDfs(root.left);
		printDfs(root.right);
	}

	public static void main(String[] args) {

		Solution s = new Solution();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);

		s.flatten(root);
	}
}
