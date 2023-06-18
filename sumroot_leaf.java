// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues
 

// Your code here along with comments explaining your approach:
// we are calling a helper function with root and currsum .. we are adding the root.val to the currsum. 
// if it is a leaf node then we add the currsum to the sum which is a global variable

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
        this.sum=0;
        sum(root,0);
        return this.sum;
    }
    private void sum(TreeNode root, int currSum)
    {
        //base
        if(root==null) return;

        //logic
        currSum = (currSum*10) + root.val ;

        if(root.left == null && root.right==null)
        {
            sum+=currSum;
        }

        sum(root.left,currSum);
        sum(root.right,currSum);
    }
} 