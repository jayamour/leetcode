import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution {

	public int maxLevelSum(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int maxSum = Integer.MIN_VALUE;
		int answer = 0;
		int level = 0;

		while ( !queue.isEmpty() ) {

			int size = queue.size();
			int sum = 0;

			for ( int i = 0; i < size; i++ ) {

				TreeNode node = queue.poll();
				sum += node.val;

				if ( node.left != null ) {
					queue.add(node.left);
				}

				if ( node.right != null ) {
					queue.add(node.right);
				}
			}

			level++;

			if ( sum > maxSum ) {
				maxSum = sum;
				answer = level;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1
				, new TreeNode(7, new TreeNode(7), new TreeNode(-8))
				, new TreeNode(0));

		System.out.println(solution.maxLevelSum(root));
	}
}
