// T.C : O(N)
// S.C : O(H)

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
        if(root == null) return sum;
         
        helper(root,0);
        return sum;
    }
    
    private void helper(TreeNode root,int num){
        // base
        if(root == null) return;
        // logic
        
        helper(root.left, num*10+root.val);
        // check if on leaf node
        // sum for left part
        if(root.left==null && root.right == null){
            sum = sum + num*10 + root.val;
            return;
        }
         // sum for right part
        helper(root.right, num*10+root.val);
    }
}