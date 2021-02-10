/**
T: O(n), n = no of nodes
S: O(d), d = depth of the tree
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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        recurse(root, 0);
        
        return sum;       
    }
    
    public void recurse(TreeNode root, int curr){
        if(root == null)
            return;
        
        curr = root.val + curr * 10;
        
        if(root.left == null && root.right == null){
            sum += curr;
        }
 
        recurse(root.left, curr);
        recurse(root.right, curr);
    }
}