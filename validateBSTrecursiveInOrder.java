//time complexity O(n)
//space complexity O(h) h is the height of the tree

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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
    public boolean inOrder(TreeNode root){
        if(root == null) return true;
        if(inOrder(root.left) == false) return false;
        if(prev != null && prev.val >= root.val) return false;
        prev = root;
        return inOrder(root.right);
    }
}
