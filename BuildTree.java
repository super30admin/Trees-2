// Problem 106. Construct Binary Tree from Inorder and Postorder Traversal
// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // base case
        if (postorder.length == 0) {
            return null;
        }
        // The last element in postorder is the root
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        // find root in inorder
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }
        // copyOfrange takes extra index towards end
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder, inLeft.length, postorder.length - 1);
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;
    }
}
