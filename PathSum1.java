// Time Complexity : O(n) n is number of nodes
// Space Complexity : O(h) h is height of the tree
// Did this code successfully run on Leetcode :
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
    int totalSum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        inorder(root,0);
        return totalSum;
    }
    
    public void inorder(TreeNode root, int sum)
    {
        if(root==null) return;
        sum = sum*10+root.val;
        inorder(root.left,sum);
        if(root.left==null && root.right==null )
        {
            totalSum+=sum;
           
        }
        inorder(root.right,sum);
        
        
    }
    
}