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

 //Time complexity is O(N)
 //Space complexity is O(N)
class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
        return 0;
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int sum){
        if(root.left==null && root.right==null){
            result=result+(sum*10)+root.val;
            return;
        }
        if(root.left!=null){
            helper(root.left, (sum*10)+root.val);
        }
        if(root.right!=null){
            helper(root.right, (sum*10)+root.val);
        }
    }
}