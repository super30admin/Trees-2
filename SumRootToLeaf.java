// Time Complexity : O(N)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum(root,0);
        return sum;
    }
    private void sum(TreeNode root, int num){
        if(root == null) return ;
        if(root.left==null && root.right == null){
            sum= sum+ num*10+root.val;
            return;
        }
        sum(root.left, num*10+root.val);
        sum(root.right, num*10+root.val);
        
    }
}