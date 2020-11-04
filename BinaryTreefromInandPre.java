import java.util.Arrays;

public class BinaryTreefromInandPre {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[0]);
		int rootIndx = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (root.val == inorder[i]) {
				rootIndx = i;
			}
		}

		int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIndx);
		int[] inRight = Arrays.copyOfRange(inorder, rootIndx + 1, inorder.length);
		int[] preLeft = Arrays.copyOfRange(preorder, 1, rootIndx + 1);
		int[] preRight = Arrays.copyOfRange(preorder, rootIndx + 1, preorder.length);

		root.left = buildTree(preLeft, inLeft);
		root.right = buildTree(preRight, inRight);
		return root;
	}
}
