// Time Complexity : O(n), where n is the number of nodes in the tree
// Space Complexity : O(h), where h is the height of the tree (due to the recursion stack)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// The goal is to find the total sum of all root-to-leaf paths, treating the path as a number.
// We traverse the tree, passing along a `currSum` that accumulates the path value.
// At each node, multiply `currSum` by 10 and add the node's value to form the current number.
// If we reach a leaf node, return the `currSum` as a complete number for that path.
// For non-leaf nodes, recursively compute the left and right subtrees and return their sum.
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
    int currSum = 0;
    public int sumNumbers(TreeNode root) {
        return helper(root, currSum);
    }
    public int helper(TreeNode root, int currSum){

        if(root == null) return 0;
        currSum = currSum*10 + root.val;

        if(root.left == null && root.right == null){
            return currSum;
        }

        int left = helper(root.left, currSum);
        int right = helper(root.right, currSum);

        return left + right;

    }

}