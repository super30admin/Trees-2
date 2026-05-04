//time comp : O(n)
//space comp: O(1)
//using recusrion to parse to each node of tree and add the values in the result which is a global variable 
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
    int res;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return res;
    }
    private void helper(TreeNode root, int curr){
        //base
        if(root==null) return;
        // logic 
        curr = curr*10+ root.val;
        if(root.left==null && root.right==null){
            res+=curr;
        }
        helper(root.left,curr);
        helper(root.right,curr);

    }
}