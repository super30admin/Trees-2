/**
 * Time Complexity - O(N) where N is the size of the input array inorder or postorder.
 * Space Complexity - O(N)
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || inorder.length != postorder.length)
            return null;
        
        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int instart, int inend, int postend) {

        if(instart < 0 || postend >= postorder.length || instart > inend) 
            return null;        
        TreeNode node = new TreeNode(postorder[postend]);
        int curIndex = instart;
        for (; curIndex < inend; curIndex++) 
            if(inorder[curIndex] == node.val)
                break;        
        node.left = buildTree(inorder, postorder, instart, curIndex - 1, postend - (inend - curIndex + 1));
        node.right = buildTree(inorder, postorder, curIndex + 1, inend, postend - 1);
        return node;
    }
}
