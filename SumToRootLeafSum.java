// Time Complexity : O(n) - where n is the number of nodes in the BST
// Space Complexity : O(1) - O(h) - where h is the height of the BST (Recursive stack space)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach -:

Traversed all the paths in the preorder manner while computing the current Sum along
the way by currSum * 10 + data point.

If we hit the leaf node, returning the computed current sum.

Eventually adding all the right leaf nodes sums
 */

class Solution1 {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }


    private int helper(TreeNode root, int currSum) {
        if(root == null) return 0;

        currSum = currSum * 10 + root.val;

        if(root.left == null && root.right == null) {
            return currSum;
        }

        return helper(root.left, currSum) + helper(root.right, currSum);
    }
}

public class SumToRootLeafSum {

}
