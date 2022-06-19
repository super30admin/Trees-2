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
    //Time complexity: O(n)
    //Space complexity: O(h) h-height of the tree
    int res;
    public int sumNumbers(TreeNode root) {
        inorder(root,0);
        return res;
    }
    private void inorder(TreeNode root,int currNum){
        if(root==null)
            return;
        inorder(root.left,currNum*10+root.val);
        if(root.left==null && root.right==null){
            res+=currNum*10+root.val;
        }
        inorder(root.right,currNum*10+root.val);
    }
}