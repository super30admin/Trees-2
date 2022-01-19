//Time Complexity: O(n)
//Space Complexity: O(1)

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
    int sum=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    private void helper(TreeNode root, int num){
        if(root==null)
            return ;
        if(root.left==null && root.right==null){
            sum+=num*10+root.val;
        }
        helper(root.left,num*10+root.val);
        helper(root.right,num*10+root.val);
    }
}
