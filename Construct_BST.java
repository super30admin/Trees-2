// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder);
    }

    private TreeNode helper(int[] preorder, int[] inorder) {
        // base case
        if(preorder.length <= 0) return null;
        int rootVal = preorder[0];
        int rootidx = -1;
        TreeNode root = new TreeNode(rootVal);

        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                rootidx = i;
                break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootidx);
        int[] inRight = Arrays.copyOfRange(inorder, rootidx+1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length+1, inorder.length);

        root.left = helper(preLeft, inLeft);
        root.right = helper(preRight, inRight);
        return root;
    }
}
