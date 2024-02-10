//Time - O(n)
//Space - O(h) h =logn or n
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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }

    public void helper(TreeNode root, int sum){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            res = res + sum*10+root.val;
            return;
        }
        helper(root.left,sum*10+root.val);
        helper(root.right, sum*10+root.val);
    }
}
