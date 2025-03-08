import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode () {}
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

	public boolean isSymmetric(TreeNode root) {

		Queue<Integer> lQ = new LinkedList<>();
		Queue<Integer> rQ = new LinkedList<>();

		dfsLeft(root.left, lQ);
		dfsRight(root.right, rQ);

		if ( lQ.size() != rQ.size() ) {
			return false;
		}

		while ( !lQ.isEmpty() ) {

			int left = lQ.poll();
			int right = rQ.poll();

//			System.out.println(left + " vs " + right);

			if ( left != right ) {
				return false;
			}
		}

		return true;
	}

	public void dfsLeft(TreeNode curr, Queue<Integer> q) {

		if ( curr == null ) {
			q.offer(-1);
			return;
		}

		q.offer(curr.val);

		if ( curr.left != null ) {
			dfsLeft(curr.left, q);
		} else {
			q.offer(-1);
		}

		if ( curr.right != null ) {
			dfsLeft(curr.right, q);
		} else {
			q.offer(-2);
		}
	}

	public void dfsRight(TreeNode curr, Queue<Integer> q) {

		if ( curr == null ) {
			q.offer(-1);
			return;
		}

		q.offer(curr.val);

		if ( curr.right != null ) {
			dfsRight(curr.right, q);
		} else {
			q.offer(-1);
		}

		if ( curr.left != null ) {
			dfsRight(curr.left, q);
		} else {
			q.offer(-2);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode lTwo = new TreeNode(2);
		TreeNode lThree = new TreeNode(3);

		root.left = lTwo;
		lTwo.right = lThree;

		TreeNode rTwo = new TreeNode(2);
		TreeNode rThree = new TreeNode(3);

		root.right = rTwo;
		rTwo.right = rThree;

		/*
		TreeNode root = new TreeNode(1);
		TreeNode lTwo = new TreeNode(2);
		TreeNode lThree = new TreeNode(3);
		TreeNode lFour = new TreeNode(4);

		TreeNode rTwo = new TreeNode(2);
		TreeNode rThree = new TreeNode(3);
		TreeNode rFour = new TreeNode(4);

		root.left = lTwo;
		lTwo.left = lThree;
		lTwo.right = lFour;

		root.right = rTwo;
		rTwo.left = rFour;
		rTwo.right = rThree;
		*/
		Solution s = new Solution();
		System.out.println(s.isSymmetric(root));
	}
}
