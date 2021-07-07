/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time Complexity : O(N)
// Space Complexity : O(logN)  : recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// A leaf node is identified as the one with left and right child as null. So whenever we encounter this scenario, we need to return the sum till that point and add it recursively to other leaf nodes.
// considering example2: Preorder[4 9 5 1 0] : 495 + 491 + 40
// by DFS apprach stack : [4, 9, 5] the current running sum will be pushed along with the node value:
// curr running sum:[0*10+4, 4*10+9, 49*10+5]


class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int sum) {
        // base case
        if(root == null) return 0;
        // logic
        sum = sum*10 + root.val;
        // logic for leaf node
        if(root.left == null && root.right == null) {
            return sum;
        }
        // recursive sum from left subtree
        int leftRecursiveSum = helper(root.left, sum);
        // recursive sum from right subtree
        int rightRecursiveSum = helper(root.right, sum);
        return leftRecursiveSum + rightRecursiveSum;
    }
}