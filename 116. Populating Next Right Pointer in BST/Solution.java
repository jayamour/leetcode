class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {}
	public Node(int val) {
		this.val = val;
	}

	public Node(int val, Node left, Node right, Node next) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.next = next;
	}
}

public class Solution {

	public Node connect(Node root) {

		if ( root == null ) {
			return root;
		}

		Node curr = root;

		while ( curr != null ) {

			Node first = curr;

			while ( curr != null ) {

				if ( curr.left != null ) {

					curr.left.next = curr.right;

					if ( curr.next != null ) {
						curr.right.next = curr.next.left;
					}
				}

				curr = curr.next;
			}

			curr = first.left;
		}

		return root;
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
//		Node eight = new Node(8);

		root.left = two;
		two.left = four;
		two.right = five;

		root.right = three;
		three.left = six;
		three.right = seven;

		Solution s = new Solution();
		s.connect(root);
	}
}
