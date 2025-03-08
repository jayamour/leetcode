import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { this.val = x; }
}

public class Solution {

	List<Integer> answer;
	Map<Integer, TreeNode> map;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

		answer = new ArrayList<>();
		map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int size = 0;

		while ( !queue.isEmpty() ) {

			size = queue.size();

			for ( int i = 0; i < size; i++ ) {

				TreeNode here = queue.poll();

				if ( here.left != null ) {
					map.put(here.left.val, here);
					queue.offer(here.left);
				}

				if ( here.right != null ) {
					map.put(here.right.val, here);
					queue.offer(here.right);
				}
			}
		}

		Map<Integer, Integer> visited = new HashMap<>();

		queue.offer(target);

		int count = 0;

		while ( k > 0 && !queue.isEmpty() ) {

			size = queue.size();

			for ( int i = 0; i < size; i++ ) {

				TreeNode here = queue.poll();

				visited.put(here.val, 1);

				if ( here.left != null && !visited.containsKey(here.left.val) ) {
					queue.offer(here.left);
				}

				if ( here.right != null && !visited.containsKey(here.right.val) ) {
					queue.offer(here.right);
				}

				if ( map.containsKey(here.val) && !visited.containsKey(map.get(here.val).val) ) {
					queue.offer(map.get(here.val));
				}
			}

			k--;
		}

		while ( !queue.isEmpty() ) {

			answer.add(queue.poll().val);
		}

		return answer;
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode one = new TreeNode(1);
		TreeNode six = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);
		TreeNode four = new TreeNode(4);
		TreeNode zero = new TreeNode(0);
		TreeNode eight = new TreeNode(8);

		root.left = five;
		root.right = one;

		five.left = six;
		five.right = two;

		two.left = seven;
		two.right = four;

		one.left = zero;
		one.right = eight;

//		TreeNode target = new TreeNode(5);

		Solution s = new Solution();
		System.out.println(s.distanceK(root, five, 2));
	}
}
