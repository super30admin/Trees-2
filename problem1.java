
// Time Complexity :O(n^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base
        if (preorder.length == 0)
            return null;

        // logic
        int root = preorder[0];
        int rootidx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                rootidx = i;
                break;
            }
        }
        TreeNode newroot = new TreeNode(root);
        int[] inleft = Arrays.copyOfRange(inorder, 0, rootidx);
        int[] inright = Arrays.copyOfRange(inorder, rootidx + 1, inorder.length);

        int[] preleft = Arrays.copyOfRange(preorder, 1, 1 + inleft.length);
        int[] preright = Arrays.copyOfRange(preorder, inleft.length + 1, preorder.length);

        newroot.left = buildTree(preleft, inleft);
        newroot.right = buildTree(preright, inright);
        return newroot;
    }
}