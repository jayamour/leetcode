import java.util.Stack;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Solution {

	public ListNode reverseList(ListNode head) {

		if ( head == null ) {
			return null;
		}

		Stack<Integer> stack = new Stack<>();

		ListNode node = head;

		while ( true ) {

			stack.push(node.val);

			if ( node.next == null ) {
				break;
			}

			node = node.next;
		}

		ListNode reversed = new ListNode(stack.pop());
		ListNode ln;
		ListNode n;

		while ( !stack.isEmpty() ) {

			ln = new ListNode(stack.pop());
			System.out.println(ln.val);

			n = findLast(reversed);
			n.next = ln;
		}

		return reversed;
	}

	public ListNode findLast(ListNode root) {

		while ( root.next != null ) {

			root = root.next;
		}

		return root;
	}

	public static void main(String[] args) {

		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		ListNode ln5 = new ListNode(5);

		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;

		Solution s = new Solution();
		System.out.println(s.reverseList(ln1));
	}
}
