import java.util.Arrays;
import java.util.HashMap;

//Problem 41
public class BinaryTree {
	HashMap<Integer, Integer> binaryMap ;
	int index; // root preorder index;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0 || preorder == null || inorder == null)
			return null;

		TreeNode root = new TreeNode(preorder[0]);
		int index = -1;
		for (int i = 0; i < inorder.length; i++) {
			if (root.val == inorder[i])
				index = i;
		}
		int[] preLeft = Arrays.copyOfRange(preorder, 1, index + 1);
		int[] preRight = Arrays.copyOfRange(preorder, index + 1, preorder.length);
		int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
		int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		root.left = buildTree(preLeft, inLeft);
		root.right = buildTree(preRight, inRight);
		return root;
	}

	public TreeNode buildTreeUsingMap(int[] preorder, int[] inorder) {
		
		if (preorder.length == 0 || inorder.length == 0 || preorder == null || inorder == null)
			return null;
		binaryMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			binaryMap.put(inorder[i], i);
		}

		return helper(preorder, inorder, 0, inorder.length - 1);
	}

	private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
		// TODO Auto-generated method stub
		// base
		if (start > end || index >= preorder.length)
			return null;
		//logic    
		int idx = binaryMap.get(preorder[index]);// root index in inorder
		TreeNode root = new TreeNode(preorder[index]);
		index++;
		root.left = helper(preorder, inorder, start, idx-1);
		root.right = helper(preorder, inorder, idx + 1, end);
	
		return root;

	}
}
