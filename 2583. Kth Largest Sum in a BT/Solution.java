import java.util.*;

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

	public long kthLargestLevelSum(TreeNode root, int k) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		List<Integer> list = new ArrayList<>();
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
			list.add(sum);
		}

		System.out.println( level );

		if ( level > k ) {
			return -1;
		}

		System.out.println("list.size() = " + list.size());

		Collections.sort(list, Collections.reverseOrder());

		return list.get(k - 1);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

//		TreeNode root = new TreeNode(5
//				, new TreeNode(8
//				, new TreeNode(2, new TreeNode(4), new TreeNode(6))
//				, new TreeNode(1))
//				, new TreeNode(9, new TreeNode(3), new TreeNode(7)));

		TreeNode root = new TreeNode(5
							, new TreeNode(8, new TreeNode(2), new TreeNode(1))
							, new TreeNode(9, new TreeNode(3), new TreeNode(7)));

		System.out.println(solution.kthLargestLevelSum(root, 4));
	}
}
