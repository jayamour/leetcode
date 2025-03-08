import java.util.ArrayList;
import java.util.List;

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

	public ListNode middleNode(ListNode head) {

		List<ListNode> list = new ArrayList<>();

		int size = 0;

		while ( head != null ) {
			System.out.println(head.val);
			list.add(head);
			head = head.next;

			size++;
		}

//		System.out.println("list.size(): " + list.size());

		return list.get(list.size() / 2);
	}

	public static void main(String[] args) {

		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);

		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;

		Solution s = new Solution();
		System.out.println(s.middleNode(one));
	}
}
