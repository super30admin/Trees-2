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
    void binarySearchTree(TreeNode root, Integer min, Integer max) {
         if(root == null) {
             return;
         }
         if(min != null && min >= root.val) {
            flag = false;
         }
          
          if(max != null && max <= root.val) {
              flag = false;
          }



        binarySearchTree(root.left, min,root.val);
        binarySearchTree(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        flag = true;
        binarySearchTree(root,null,null);
        return flag;
    }
}