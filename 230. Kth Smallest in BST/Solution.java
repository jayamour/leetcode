import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution {

	public int kthSmallest(TreeNode root, int k) {

		List<Integer> list = new ArrayList<>();
		dfs(root, k, list);

		return list.get(k-1);
	}

	public void dfs(TreeNode root, int k, List<Integer> list) {

		if ( root.left != null ) {
			dfs(root.left, k, list);
		}

		list.add(root.val);

		if ( root.right != null ) {
			dfs(root.right, k, list);
		}
	}

	public static void main(String[] args) {

		//{41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23}
		//	1 2 3 4,
	}
}
