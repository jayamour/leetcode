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

	public ListNode deleteDuplicates(ListNode head) {

		ListNode ans = new ListNode(head.val, head.next);
//		ans = head;

		Map<Integer, Integer> map = new HashMap<>();

		Stack<ListNode> q = new Stack<>();

		ListNode last;

		while ( head.next != null ) {

			if ( map.get(head.val) == null ) {

				System.out.println("push => " + head.val);
				map.put(head.val, 1);
				q.push(head);
			} else {

				if ( q.size() == 0 ) {
					ans = head.next;
				} else
				{

					ListNode bf = q.pop();
					System.out.println("bf.val: " + bf.val);

					if (q.size() != 0) {

						last = q.pop();

						//				System.out.println("last.val: " + last.val);

						while (head.next != null && head.val != head.next.val) {
//												System.out.println("   head.val: " + head.val);
							head = head.next;
						}

						last.next = head;
						q.push(last);

//										System.out.println("head.val: " + head.val);
						map.put(head.val, 1);
						q.push(head);
					} else {
//					map.put(head.val, null);
					}
				}
			}

			if ( head.next != null ) {
				head = head.next;
			}
		}

		return ans;
	}

	public static void main(String[] args) {

		ListNode a1 = new ListNode(1);
		ListNode b1 = new ListNode(2);
		ListNode c1 = new ListNode(3);
		ListNode c2 = new ListNode(3);
		ListNode d1 = new ListNode(4);
		ListNode d2 = new ListNode(4);
		ListNode e1 = new ListNode(5);

		a1.next = b1;
		b1.next = c1;
		c1.next = c2;
		c2.next = d1;
		d1.next = d2;
		d2.next = e1;

		ListNode one1 = new ListNode(1);
		ListNode one2 = new ListNode(1);
		ListNode one3 = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);

		one1.next = one2;
		one2.next = one3;
		one3.next = two;
		two.next = three;

		Solution s = new Solution();
		ListNode ans = s.deleteDuplicates(one1);

		System.out.println("==> " + ans.val);

		while ( ans.next != null ) {
			System.out.print(ans.val + ", ");
			ans = ans.next;
		}
	}
}
