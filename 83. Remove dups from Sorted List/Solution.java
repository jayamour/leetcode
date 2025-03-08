class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Solution {

	public ListNode deleteDuplicates(ListNode head) {

		ListNode list = head;

		//	1 1 1 2 3 3 3
		while ( list != null ) {

			if ( list.next == null ) {
				break;
			}

			if ( list.val == list.next.val ) {
				list.next = list.next.next;
			} else {
				list = list.next;
			}
		}

		return head;
	}

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		ListNode one1 = new ListNode(1);
		ListNode one2 = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three1 = new ListNode(3);
		ListNode three2 = new ListNode(3);
		ListNode three3 = new ListNode(3);

		head.next = one1;
		one1.next = one2;
		one2.next = two;
		two.next = three1;
		three1.next = three2;
		three2.next = three3;

//		head.next = one1;
//		one1.next = two;

		Solution s = new Solution();
		s.deleteDuplicates(head);
	}
}
