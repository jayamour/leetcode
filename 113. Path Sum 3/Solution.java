import java.util.ArrayList;
import java.util.List;

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

	List<List<Integer>> result;

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

		result = new ArrayList<>();

		dfs(root, new ArrayList<>(), 0, targetSum);

		return result;
	}

	public void dfs(TreeNode node, List<Integer> path, int sum, int targetSum) {

		if ( node == null ) {
			return;
		}

		path.add(node.val);
		sum += node.val;

		//	leaf node
		if ( node.left == null && node.right == null && sum == targetSum ) {

			List<Integer> list = new ArrayList<>(path);
			result.add(list);
			return;
		}

		if ( node.left != null ) {
			dfs(node.left, path, sum, targetSum);
			path.remove(path.size() - 1);
		}

		if ( node.right != null ) {
			dfs(node.right, path, sum, targetSum);
			path.remove(path.size() - 1);
		}
	}

	public static void main(String[] args) {

		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node11 = new TreeNode(11);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node8 = new TreeNode(8);
		TreeNode node13 = new TreeNode(13);
		TreeNode nodeRight4 = new TreeNode(4);
		TreeNode nodeRight5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);

		node5.left = node4;
		node4.left = node11;
		node11.left = node7;
		node11.right = node2;

		node5.right = node8;
		node8.left = node13;
		node8.right = nodeRight4;
		nodeRight4.left = nodeRight5;
		nodeRight4.right = node1;

		Solution s = new Solution();
		System.out.println(s.pathSum(node5, 22));
	}
}
