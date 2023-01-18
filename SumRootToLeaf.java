//tc : O(n)
//sc : O(height of the tree for the stack memory)
//Run successfully on leetcode
//no problems 

//Reach every end node and add it to the 
//global varible sum:)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, root.val);
        return sum;
    }

    private void helper(TreeNode root, int num) {
        // base case
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        // logic
        if (root.left != null)
            helper(root.left, num * 10 + root.left.val);
        if (root.right != null)
            helper(root.right, num * 10 + root.right.val);
    }
}