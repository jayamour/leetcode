class Solution {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		ListNode p1 = list1;
		ListNode p2 = list2;

		ListNode result = new ListNode(0);
		ListNode answer = result;

		while ( p1 != null || p2 != null ) {

			if ( p1 == null && p2 != null ) {

				System.out.println("p2.val = " + p2.val);

				result.next = p2;
				// result = result.next;
				break;
//				p2 = p2.next;
			} else if ( p1 != null && p2 == null ) {
				result.next = p1;
				// result = result.next;
//				p1 = p1.next;
				break;
			} else {

				System.out.println(p1.val + " vs " + p2.val);

				if ( p1.val <= p2.val ) {
					result.next = p1;
					p1 = p1.next;
				} else {
					result.next = p2;
					p2 = p2.next;
				}
				result = result.next;
			}
		}

		//	1 -> 2 -> 4
		//	1 -> 3 -> 4

		return answer.next;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode list1 = new ListNode(-9);
		ListNode list2 = new ListNode(3);

		list1.next = list2;

		ListNode list4 = new ListNode(5);
		ListNode list5 = new ListNode(7);

		list4.next = list5;

		ListNode result = solution.mergeTwoLists(list1, list4);

		while ( result != null ) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}