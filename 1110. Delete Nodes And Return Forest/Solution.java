import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	TreeNode(int x, TreeNode left, TreeNode right) {
		this.val = x;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "[val=" + val + "]";
	}
}

public class Solution {

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

		if ( root == null ) return new ArrayList<>();

		Set<Integer> toDeleteSet = new HashSet<>();
		for ( int val : to_delete ) {
			toDeleteSet.add(val);
		}

		List<TreeNode> forest = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Map<TreeNode, TreeNode> parentMap = new HashMap<>();

		queue.add(root);
		if ( !toDeleteSet.contains(root.val) ) {
			forest.add(root);
		}

		// BFS 반복문
		while ( !queue.isEmpty() ) {
			TreeNode current = queue.poll();

			if ( current.left != null ) {
				queue.add(current.left);
				parentMap.put(current.left, current);
			}
			if ( current.right != null ) {
				queue.add(current.right);
				parentMap.put(current.right, current);
			}

			// 삭제할 노드라면 부모와의 연결을 끊고, 자식들을 새로운 루트로 추가
			if ( toDeleteSet.contains(current.val) ) {
				if ( current.left != null && !toDeleteSet.contains(current.left.val) ) {
					forest.add(current.left);
				}
				if ( current.right != null && !toDeleteSet.contains(current.right.val) ) {
					forest.add(current.right);
				}

				// 부모 노드 업데이트
				if ( parentMap.containsKey(current) ) {
					TreeNode parent = parentMap.get(current);
					if ( parent.left == current ) parent.left = null;
					if ( parent.right == current ) parent.right = null;
				}
			}
		}

		return forest;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1
				, new TreeNode(2
				, new TreeNode(4), new TreeNode(5))
				, new TreeNode(3
				, new TreeNode(6), new TreeNode(7)));

		Solution s = new Solution();

		List<TreeNode> forest = s.delNodes(root, new int[]{3, 5});
		for ( TreeNode node : forest ) {
			printTree(node);
			System.out.println();
		}
	}

	// 트리 출력 함수 (BFS 기반)
	public static void printTree(TreeNode root) {
		if ( root == null ) return;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while ( !queue.isEmpty() ) {
			TreeNode node = queue.poll();
			System.out.print(node.val + " ");

			if ( node.left != null ) queue.add(node.left);
			if ( node.right != null ) queue.add(node.right);
		}
	}
}
