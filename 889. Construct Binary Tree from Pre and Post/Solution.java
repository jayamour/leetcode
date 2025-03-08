class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Solution {

	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

		if ( preorder.length == 0 || postorder.length == 0 ) return null;

		if ( preorder.length == 1 ) return new TreeNode(preorder[0]);

		if ( preorder.length == 2 ) return new TreeNode(preorder[0], new TreeNode(preorder[1]), null);

//		TreeNode root = new TreeNode(preorder[0],
//				new TreeNode(preorder[1]),
//				new TreeNode(postorder[postorder.length - 2]));

		return makeSubTree(preorder, postorder, 0, preorder.length - 1, 0, postorder.length - 1);
	}

	private TreeNode makeSubTree(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {

		if ( preStart > preEnd ) return null;

		if ( preStart == preEnd ) return new TreeNode(preorder[preStart]);

		TreeNode root = new TreeNode(preorder[preStart]);// 현재 서브트리의 루트 노드 생성 (preorder의 첫 값)

		int val = preorder[preStart + 1];

		int m = 0;

		for ( int j = postStart; j <= postEnd; j++ ) {
			if ( postorder[j] == val ) {
				m = j;
				break;
			}
		}

		int leftSubtreeSize = m - postStart + 1;

		//	(i1 + 1) ~ m
		root.left = makeSubTree(preorder, postorder, preStart + 1, preStart + leftSubtreeSize, postStart, m);
		//	(m + 1) ~ i2
		root.right = makeSubTree(preorder, postorder, preStart + leftSubtreeSize + 1, preEnd, m + 1, postEnd - 1);

		return root;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] preorder = {1, 2, 4, 5, 3, 6, 7};
		int[] postorder = {4, 5, 2, 6, 7, 3, 1};
		TreeNode root = solution.constructFromPrePost(preorder, postorder);
	}
}
