import java.util.HashMap;
import java.util.Map;

class TreeNode {
	int val;
	int lv;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode(int val) {
		this.val = val;
	}
	@Override
	public String toString() {

		if ( parent != null ) {
			return val + "'s parent: " + parent.val + ", lv: " + lv;
		} else {
			return val + ": root, lv: " + lv;
		}
	}
}

public class Solution {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		Map<Integer, Integer> map = new HashMap<>();

		dfs(root, p, q, null, 0, map);

		System.out.println(map.size());

		int pLv = map.get(p.val);
		int qLv = map.get(q.val);

		System.out.println("pLv: " + pLv + ", " + qLv);

		//		2 < 6
		if ( pLv < qLv ) {

			for ( int i = 0; i < (qLv - pLv); i++ ) {
				System.out.println("q...1 " + q);
				q = q.parent;
				System.out.println("q...2 " + q);
			}
		} else if ( pLv > qLv ) {
			for ( int i = 0; i < (pLv - qLv); i++ ) {
				p = p.parent;
			}
		}

		System.out.println("p: " + p);
		System.out.println("q: " + q);
		TreeNode lca = findAncestor(p, q);

		return lca;
	}

	public TreeNode findAncestor(TreeNode p, TreeNode q) {

		if ( p.val == q.val) {
			return p;
		}

		System.out.println(p.val + " vs " + q.val);
		System.out.println(p);

		if ( p.parent.val == q.parent.val ) {
			return p.parent;
		}

		while ( p.parent.val != q.parent.val ) {

			p = p.parent;
			q = q.parent;

			System.out.println("ppp: " + p);
			System.out.println("qqq: " + q);
		}

		return p.parent;
	}

	public void dfs(TreeNode root, TreeNode p, TreeNode q, TreeNode parent, int lv, Map<Integer, Integer> map) {

		if ( root == null ) {
			return;
		}

		root.lv = lv;
		if ( parent != null ) {
			root.parent = parent;
		}

		map.put(root.val, lv);

		System.out.println(root.val + " vs p: " + p.val);
		if ( root.val == p.val ) {
			System.out.println("root => " + root);
			p.parent = root.parent;
			p.lv = root.lv;
			System.out.println("p: " + p);
		}

		System.out.println(root.val + " vs q: " + q.val);
		if ( root.val == q.val ) {
			q.parent = root.parent;
			q.lv = root.lv;
		}

		System.out.println(root);

		dfs(root.left, p, q, root,lv + 1, map);
		dfs(root.right, p, q, root,lv + 1, map);
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);
		TreeNode four = new TreeNode(4);
		TreeNode one = new TreeNode(1);
		TreeNode zero = new TreeNode(0);
		TreeNode eight = new TreeNode(8);

		root.left = five;
		five.left = six;
		five.right = two;
		two.left = seven;
		two.right = four;

		root.right = one;
		one.left = zero;
		one.right = eight;

		Solution s = new Solution();

		TreeNode p = new TreeNode(6);
		TreeNode q = new TreeNode(0);

		TreeNode node = s.lowestCommonAncestor(root, p, q);
		System.out.println(node.val);
	}
}
