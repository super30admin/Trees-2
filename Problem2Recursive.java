// ## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

// Time Complexity : O(N)
// Space Complexity : O(Height of Tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A

// 1. Recursive
// Your code here along with comments explaining your approach
// Store the total sum in a global variable.
// Recurse on each node while maintaining the path sum in local for each recursive call
// if we reach a leaf node, add it to the global sum

class Solution {
    int totalSum;

    private void helper(TreeNode root, int currD){
        //base
        if(root==null){
            return;
        }

        int currPathSum = currD*10+root.val;
        if(root.left==null && root.right==null){
            //leaf node - add path sum to global
            totalSum += currPathSum;
        }

        //logic
        helper(root.left, currPathSum);
        helper(root.right, currPathSum);
    }

    public int sumNumbers(TreeNode root) {
        this.totalSum = 0;
        helper(root, 0);
        return totalSum;
    }
}
