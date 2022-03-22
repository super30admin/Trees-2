// Time Complexity : O(n^2)
// Space Complexity : O(h) where h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeRec(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRec(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {

        // base
        if (postStart > postEnd) {
            return null;
        }

        int val = postorder[postEnd];

        int index = 0;
        
        // getting index
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }

        int shift = index - inStart;
        
        TreeNode root = new TreeNode(val);

        // rec
        root.left = buildTreeRec(postorder, postStart, postStart + shift - 1, inorder, inStart, index - 1);
        root.right = buildTreeRec(postorder, postStart + shift, postEnd - 1, inorder, index + 1, inEnd);

        return root;
    }
}  