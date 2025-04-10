
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Time Complexity : O(n) - no new arrays
// Space Complexity : O(n)  + O(n) = O(n)

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) return null;

        int rootVal = postorder[postorder.length - 1]; // root is last in postorder

        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }

        // Left and right subtrees in inorder
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);

        // Postorder left and right
        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder, inLeft.length, postorder.length - 1); // skip last (root)

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);

        return root;
    }
}