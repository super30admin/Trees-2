// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    public TreeNode helper(int postStart, int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        // the root
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0;

        // finding partion for right and left subtree
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == inorder[i]) {
                inIndex = i;

            }
        }
        root.left = helper(postStart, postStart + inIndex - inStart - 1, inStart, inIndex - 1, inorder, postorder);
        root.right = helper(postStart + inIndex - inStart, postEnd - 1, inIndex + 1, inEnd, inorder, postorder);
        return root;
    }
}