//Sum Root to Leaf Numbers
//Time COmplexity: O(n)
//Space Complexit: O(H)
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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int curr){
        if(root == null) return;
        curr = curr*10 + root.val;

        if(root.left==null && root.right==null){
            result+=curr;
        }
        helper(root.left,curr);
        helper(root.right,curr);
    }
}