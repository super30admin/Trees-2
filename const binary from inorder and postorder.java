time complexity: O(n)
space complexity: O(h)

class Solution { //taking the last element in postorder array as the root
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    return build(postorder, postorder.length - 1, inorder, 0, inorder.length -1);
    }
    private TreeNode build(int[] postorder, int posIdx, int[] inorder, int inStart, int inEnd){ //finding the position of the root in the inorder array
        if(inStart > inEnd || posIdx < 0) return null;
        TreeNode root = new TreeNode(postorder[posIdx]);
        int i = 0;
        for(i = inStart; i <= inEnd; i ++){
            if(inorder[i] == postorder[posIdx]) break;
        }

        root.right = build(postorder, posIdx - 1, inorder, i + 1, inEnd);  // locating the range for left sub-tree and right sub-tree and performing recursion
        root.left = build(postorder, posIdx - 1 - (inEnd - i), inorder, inStart, i - 1);
        return root;
    }
}