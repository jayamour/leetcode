class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode () {}
	TreeNode(int x) { val = x; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution {

	public TreeNode sortedArrayToBST(int[] nums) {
		return makeTree(0, nums.length - 1, nums);
	}

	public TreeNode makeTree(int l, int r, int[] nums) {

		if ( l > r ) return null;

		int mid = l + (r - l) / 2;

		TreeNode root = new TreeNode(nums[mid]);

		root.left = makeTree(l, mid - 1, nums);
		root.right = makeTree(mid + 1, r, nums);

		return root;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {-10, -3, 0, 5, 9};
		TreeNode root = solution.sortedArrayToBST(nums);
	}
}
