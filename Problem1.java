import javax.swing.tree.TreeNode;

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
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root, null , null);
        return this.flag;
    }

    private void helper(TreeNode root, Integer min, Integer max){
        // base case
        if(root == null) return;

        //logic
        if(max != null && root.val >= max){
            flag = false;
        }
        if(min != null && root.val <=min){
            flag = false;
        }
        helper(root.left, min, root.val);
        if(flag){
        helper(root.right, root.val, max);
        }
    }
}