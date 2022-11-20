Problem 129 (sum root to leaf numbers)

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


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
    int total;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        sum(root,0);
        return total;
        
    }
    private void sum(TreeNode root, int total1)
    {
        if(root==null)return;
        if(root.left==null && root.right==null)
        {
            total=total+total1*10+root.val;
            return;
        }
        
        sum(root.left, total1*10+root.val);
        
        sum(root.right,total1*10+root.val);
    }
}
