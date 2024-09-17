
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Integer result;
    public int sumNumbers(TreeNode root) {
        result = 0;
        if(root == null) return result;
        
        helper(root, 0);
        return result;
 
    }
    private void helper(TreeNode root, int runningValue){
        if(root.left == null || root.right == null){
            result+= runningValue * 10 + root.val;
        return;
        }
        
        runningValue = runningValue * 10 + root.val;
        if(root.left != null) helper(root.left, runningValue);
        if(root.right != null) helper(root.right, runningValue);
    }
}