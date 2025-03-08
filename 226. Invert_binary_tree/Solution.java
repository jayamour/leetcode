import java.util.LinkedList;
import java.util.Queue;

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

class Tree {

	TreeNode root;

	//	2
	public void add(int item) {

		TreeNode newNode = new TreeNode(item);

		if ( root == null ) {
			root = newNode;
			return;
		}

		//	4
		TreeNode curr = root;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(curr);

		while ( !q.isEmpty() ) {

			//	4
			curr = q.poll();

			if ( curr.left == null ) {
				curr.left = newNode;
				break;
			}

			q.offer(curr.left);

			if ( curr.right == null ) {
				curr.right = newNode;
				break;
			}

			q.offer(curr.right);
		}
	}

	public void print() {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while ( !queue.isEmpty() ) {

			TreeNode node = queue.poll();
			System.out.println(node.val);

			if ( node.left != null ) {
				queue.offer(node.left);
			}

			if ( node.right != null ) {
				queue.offer(node.right);
			}
		}
	}
}

public class Solution {

	Tree tree = new Tree();

	public void dfs(TreeNode node) {

		if ( node == null ) {
			return;
		}

		System.out.println(node.val);

		if ( node.left != null ) {
			dfs(node.left);
		}

		if ( node.right != null ) {
			dfs(node.right);
		}
	}

	public void bfs(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while ( !queue.isEmpty() ) {

			TreeNode node = queue.poll();

			if ( node == null ) {
				continue;
			}

			tree.add(node.val);

			if ( node.right != null ) {
				queue.offer(node.right);
			}

			if ( node.left != null ) {
				queue.offer(node.left);
			}
		}
	}

	public TreeNode invertTree(TreeNode root) {

		if ( root == null ) {
			return null;
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);

		return root;
	}

	public static void main(String[] args) {

		Solution s = new Solution();

		int [] arr = {1, 2};

		Tree rootTree = new Tree();

		for ( int i = 0; i < arr.length; i++ ) {
			rootTree.add(arr[i]);
		}

//		rootTree.print();

//		tree.print();
//		s.dfs(root);

		s.bfs(s.invertTree(rootTree.root));
	}
}
