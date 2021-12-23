// Time Complexity = O(n), where n is the number of nodes in the tree
// Space Complexity = O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Logic: When we reach the leaf node, we add the currSum to the final sum variable and return.
// Everytime we call helper function with left and right recursively, we pass currentSum as (currSum*10)+root.val
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        helper (root, 0);
        return sum;
    }

    private void helper (TreeNode root, int currSum) {
        // base case
        if (root == null) {
            return;
        }

        // Logic
        currSum = (currSum*10)+root.val;
        if (root.left == null && root.right == null) {
            sum += currSum;
            return;
        }
        helper(root.left, currSum);
        helper(root.right, currSum);
    }
}