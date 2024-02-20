
// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

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
public class Solution {
    int sum = 0;
    public int SumNumbers(TreeNode root) {
        FindTreeSum(root, 0);
        return sum;
    }

    private void FindTreeSum(TreeNode root, int curr) {
        if(root == null) return;

        //Compute current value till leaf node is found.
        curr = curr * 10 + root.val;
        if(root.left == null && root.right == null) {
            //if leaf node is found add the computed value to sum.
            sum += curr;
        }
        //Traverse left
        FindTreeSum(root.left, curr);
        //Traverse right       
        FindTreeSum(root.right, curr);
    }
}