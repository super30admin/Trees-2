Time Complexity-O(n)
Space Complexity-O(1)

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    return helper(inorder, inorder.length-1, 0, postorder, postorder.length-1);
}

private TreeNode helper(int[] inorder, int start, int end, int[] postorder,
		int pStart) {
	if (pStart < 0 || start < end)
		return null;
	TreeNode root = new TreeNode(postorder[pStart]);
	int index = start;
	for (int i = start; i >= end; i--) {
		if (inorder[i] == postorder[pStart]) {
			index = i;
			break;
		}
	}
	root.right = helper(inorder, start, index+1, postorder, pStart-1);
	root.left = helper(inorder, index - 1, end, postorder, pStart - (start - index) -1);
	return root;
}
}
