import java.util.*;

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

	public void reorderList(ListNode head) {

		ListNode slow = head;
		ListNode fast = head.next;

		while ( fast != null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode second = slow.next;
		slow.next = null;

		ListNode prev = null;

		ListNode temp;

		//	1 2 3 4 5 6 7
		//	1 7 2 6 3 5 4

		//	slow: 4
		//	second: 5, 6, 7

		while ( second != null ) {
			
			temp = second.next;	//	temp: 6, 7
			second.next = prev;	//	5.next = null, 6.next = 5, 7.next = 6;
			prev = second;		//	prev: 5, 6, 7
			second = temp;		//	sec: 6, 7
		}

		ListNode first = head;
		second = prev;

		ListNode temp1, temp2 = null;

		while ( second != null ) {

			temp1 = first.next;
			temp2 = second.next;

			first.next = second;
			second.next = temp1;

			first = temp1;
			second = temp2;
		}
	}

	public static void main(String[] args) {

		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		ListNode g = new ListNode(7);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;

		Solution s = new Solution();
		s.reorderList(a);
	}
}
