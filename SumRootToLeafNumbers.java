// Time Complexity : O(Total number of nodes)
// Space Complexity : O(height of tree)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        int currentSum = 0; // local variable to store sum
        if(root == null) { // null check
            return 0;
        }
        helper(root, currentSum);
        return sum;
    }

    public void helper(TreeNode root, int currentSum) {
        // base
        if(root == null) {
            return;
        }
        currentSum = currentSum * 10 + root.val;
        // condition
        // check if current node is leaf node or not
        if(root.left == null && root.right == null) {
            // it is leaf node, perform all calculations
            sum += currentSum; // update global sum
            return;
        }
        // logic
        helper(root.left, currentSum); // explore left side of tree
        helper(root.right, currentSum); // explore right side of tree
    }
}

