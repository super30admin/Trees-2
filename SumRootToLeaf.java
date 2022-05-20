import javax.swing.tree.TreeNode;

// Time Complexity : O(n), visit each node once
// Space Complexity : O(h), size of recursion stack, where h is height of stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
    int sum = 0;
    public int sumNumbers(TreeNode root) {    
        preorder(root, 0);
        return sum;
    }
    
    private void preorder(TreeNode r, int currNumber){
        if (r != null){
            currNumber = currNumber * 10 + r.val;
            
            if (r.left == null && r.right == null){
                sum += currNumber;
            }
            
            preorder(r.left, currNumber);
            preorder(r.right, currNumber);
        }
    }
}