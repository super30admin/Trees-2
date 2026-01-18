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

// Solution 1 - Testing by passing result as a fucnction parameter
// TC - O(n)
// SC - O(1)
// class Solution {
// public int sumNumbers(TreeNode root) {
// return helper(root, 0, 0);

// }

// private int helper(TreeNode node, int currSum, int res) {
// // Base case
// if(node == null) return 0;

// // Logic
// currSum = currSum*10 + node.val; // for every node we will multply the
// currSum by 10 and add the current node value.
// if(node.left == null && node.right ==null) {
// res+=currSum;
// return res;
// }

// // Left Node
// int left = helper(node.left, currSum, res);

// // Right Node
// int right = helper(node.right, currSum, res);

// return left+right;

// }
// }

// Solution 2
// TC - O(n)
// SC - O(1)
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);

    }

    private int helper(TreeNode node, int currSum) {
        // Base case
        if (node == null)
            return 0;

        // Logic
        currSum = currSum * 10 + node.val; // for every node we will multply the currSum by 10 and add the current node
                                           // value.
        if (node.left == null && node.right == null) {
            return currSum;
        }

        // Left Node
        int left = helper(node.left, currSum);

        // Right Node
        int right = helper(node.right, currSum);

        return left + right;

    }
}