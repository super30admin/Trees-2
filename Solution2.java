// Leetcode Problem : https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I maintain a global variable sum(initially=0). I call dfs on root with initial val = 0. In the fn, 
 * If root ==null I return. I calculate val as val*10 + root.val. If root is a leaf node, I add val to sum. Then I recursively call the fn on
 * root.left and root.right.
 */

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
        dfs(root,0);
        return sum;
    }

    public void dfs(TreeNode root, int val)
    {
        if(root==null)
        {
            return;
        }
        val=val*10+root.val;
        if(root.left==null && root.right==null)
        {
            sum+=val;
        }
        dfs(root.left,val);
        dfs(root.right,val);
    }
}