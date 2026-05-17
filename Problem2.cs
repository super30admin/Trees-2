// Time Complexity : O(n)
// Space Complexity : O(h) space taken up by the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I perform DFS on the tree, I use a global variable totalSum to keep track of sum so far. If root is null, I simply return from the helper method. I calculate sum as sum = sum * 10 + root.val. 
If the current node is a lead node, I add sum to totalSum and return from the helper method.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution
{
    private int totalSum;
    public int SumNumbers(TreeNode root)
    {
        totalSum = 0;
        Helper(root, 0);
        return totalSum;
    }

    private void Helper(TreeNode root, int sum)
    {
        if (root == null)
        {
            return;
        }

        sum = sum * 10 + root.val;

        if (root.left == null && root.right == null)
        {
            totalSum += sum;
            return;
        }

        Helper(root.left, sum);
        Helper(root.right, sum);
    }
}