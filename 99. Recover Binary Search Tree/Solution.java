class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
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

	TreeNode first = null;
	TreeNode second = null;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {
		if ( root == null ) {
			return;
		}

		inorder(root);

		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	public void inorder(TreeNode root) {
		
		if ( root == null ) return;

		inorder(root.left);

		System.out.println(prev.val + " > " + root.val);
		if ( first == null && prev.val > root.val ) {
			System.out.println(root.val);
			first = prev;
		}

		if ( first != null ) System.out.println(prev.val + " vs " + root.val);
		if ( first != null && prev.val > root.val ) {
			System.out.println("root.val = " + root.val);
			second = root;
		}

		prev = root;

		inorder(root.right);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		TreeNode a = new TreeNode(8);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(9);
		TreeNode e = new TreeNode(3);
		TreeNode f = new TreeNode(10);

		root.left = a;
		a.left = b;
		a.right = c;

		root.right = d;
		d.left = e;
		d.right = f;

		Solution s = new Solution();
		s.recoverTree(root);
	}
}
