import java.util.LinkedList;
import java.util.Queue;

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

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if ( p.val != q.val ) {
			return false;
		}

		if ( p == null && q == null ) {
			return true;
		}

		if ( p == null && q != null ) {
			return false;
		}

		if ( p != null && q == null ) {
			return false;
		}

		Queue<TreeNode> queueP = new LinkedList<>();
		Queue<TreeNode> queueQ = new LinkedList<>();
		queueP.offer(p);
		queueQ.offer(q);

		while ( !queueP.isEmpty() ) {

			int size = queueP.size();

			for ( int i = 0; i < size; i++ ) {

				TreeNode nodeP = queueP.poll();
				TreeNode nodeQ = queueQ.poll();

				if ( nodeP.val != nodeQ.val ) {
					return false;
				}

				if ( nodeP.left == null && nodeQ.left != null ) {
					return false;
				} else if ( nodeP.left != null && nodeQ.left == null ) {
					return false;
				} else if ( nodeP.right == null && nodeQ.right != null ) {
					return false;
				} else if ( nodeP.right != null && nodeQ.right == null ) {
					return false;
				}

				if ( nodeP.left != null ) {
					queueP.offer(nodeP.left);
				}

				if ( nodeQ.left != null ) {
					queueQ.offer(nodeQ.left);
				}

				if ( nodeP.right != null ) {
					queueP.offer(nodeP.right);
				}

				if ( nodeQ.right != null ) {
					queueQ.offer(nodeQ.right);
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {

		TreeNode p = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode one = new TreeNode(1);

		p.left = two;
		p.right = one;

		TreeNode q = new TreeNode(1);
		TreeNode qOne = new TreeNode(1);
		TreeNode qTwo = new TreeNode(2);

		q.left = qOne;
		q.right = qTwo;

		Solution s = new Solution();
		System.out.println(s.isSameTree(p, q));
	}
}
