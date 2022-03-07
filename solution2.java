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
/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
    
    public int sum(TreeNode node, int val){
        if(node==null){
            return 0;
        }
        
        if(node.left==null && node.right==null){
            return 10 * val + node.val;
        }
        
        int left = sum(node.left, 10 * val + node.val);
        int right = sum(node.right, 10 * val + node.val);
        
        return left + right;
        
    }
}
