// Time Complexity : O(V) we will essentially go over each element V
// Space Complexity : DFS uses a stack internally for recursion, without considering it O(1) space complexity.
// The stack will at best have elements of the same level. O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Level order traversal and DFS

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
        if(root == null) return 0;
        calculateSum(root, 0);

        return sum;

    }
//DFS approach
//Maintain currSum for each level. and keep adding it at every level.
//For the leaf nodes add it to the Final Sum.
    void calculateSum(TreeNode root, int currSum) {
        if(root == null) return;

        currSum = currSum * 10 + root.val;
        if(root .left == null && root.right == null) {
            sum += currSum;
        }
        calculateSum(root.left, currSum);
        calculateSum(root.right, currSum);
    }
}
