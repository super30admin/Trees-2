// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Multiply node by 10 while storing on to a stack. 
// calculate total sum while returning from stack and returnn total sum.
 
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
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        //sum = 0;
        return dfs(root, 0);
        //return sum;
    }

    private int dfs(TreeNode root, int currNum){
        //base case
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            //sum = sum + currNum * 10 + root.val;
            return currNum * 10 + root.val;// to avoid additional case below when root's left & right are null.
        }

        int case1 = dfs(root.left, currNum *10 + root.val);
        int case2 = dfs(root.right, currNum *10 + root.val);
        
        return case1 + case2;
    }
}