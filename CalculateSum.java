// Time Complexity : O(n)
// Space Complexity : O(l) - l is the height of tree
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class Solution {
    private int output = 0;

    public int sumNumbers(TreeNode root) {

        calculate(root, 0);

        return output;

    }

    private void calculate(TreeNode root, int curr) {
        if (root == null)
            return;

        // calculate till we reach leaf
        curr = curr * 10 + root.val;

        // if we reached a leaf add to the output
        if (root.left == null && root.right == null) {
            output += curr;
            return;
        }

        calculate(root.left, curr);
        calculate(root.right, curr);
    }
}