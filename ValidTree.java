
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
    int result;
    public int sumNumbers(TreeNode root) {
        int currsum = 0;
        sum(root, currsum);
        return result;
    }
    
    private void sum(TreeNode root, int currsum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            result =  result+ (currsum*10 + root.val);
        }
        sum(root.left, currsum*10 + root.val) ;
        sum(root.right, currsum*10 + root.val);
            
    }
}
   