public class Solution {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int sumOfLeftLeaves(TreeNode root) {

		if ( root == null ) {
			return 0;
		}

		int sum = 0;

		if ( root.left != null && root.left.left == null && root.left.right == null ) {
			sum = sum + root.left.val;
		} else {
			sum = sum + sumOfLeftLeaves(root.left);
		}

		sum += sumOfLeftLeaves(root.right);

		return sum;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
//		TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
		Solution solution = new Solution();
		System.out.println(solution.sumOfLeftLeaves(root));
	}
}
