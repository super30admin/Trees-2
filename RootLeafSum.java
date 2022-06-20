// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {

    int total = 0;

    private void helper(TreeNode root, int sum) {

        if (root == null) return;

        sum = sum * 10 + root.val;

        // check if its a leaf node
        if (root.left == null && root.right == null) {
            total += sum;
            return;
        }

        // Go to left and right with the sum
        helper(root.left, sum);
        helper(root.right, sum);

    }

    public int sumNumbers(TreeNode root) {

        helper(root, 0);

        return total;

    }
}