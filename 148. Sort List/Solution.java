class ListNode {
	int val;
	ListNode next;
	ListNode () {}
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Solution {

	public ListNode sortList(ListNode head) {

		if ( head == null || head.next == null ) {
			return head;
		}

		ListNode left = head;
		ListNode right = getMid(head);

		ListNode tmp = right.next;
		right.next = null;
		right = tmp;

		left = sortList(left);
		right = sortList(right);

		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {

		ListNode tail = new ListNode();
		ListNode dummy = tail;

//		System.out.println("dummy.next = " + dummy.next.val);

		while ( left != null && right != null ) {
			if ( left.val < right.val ) {
				tail.next = left;
				left = left.next;
			} else {
				tail.next = right;
				right = right.next;
			}
			tail = tail.next;
		}

		if ( left != null ) {
			tail.next = left;
		}

		if ( right != null ) {
			tail.next = right;
		}

		return dummy.next;
	}

	public ListNode getMid(ListNode head) {

		ListNode slow = head;
		ListNode fast = head.next;

		//	  s
		//	4 2 1 3 0
		//	      f

		while ( fast != null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static void main(String[] args) {
		ListNode a = new ListNode(4);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(3);
//		ListNode e = new ListNode(-6);

		a.next = b;
		b.next = c;
		c.next = d;
//		d.next = e;

		Solution s = new Solution();
		s.sortList(a);
	}
}
