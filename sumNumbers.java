// Time Complexity : O(n), where n is the number of nodes in the tree.
// Space Complexity : O(h), where h is the height of the tree.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * 1. Recursively traverse the tree and keep track of the current sum untill we reach the leaf node.
 * 2. Return the sum of left and right subtree to the parent node.
 */

class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int currSum){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            currSum = currSum * 10 + root.val;
            return currSum;
        }
        currSum = currSum * 10 + root.val;

        int left = sumNumbers(root.left, currSum);
        int right = sumNumbers(root.right, currSum);

        return left + right;
    }
}