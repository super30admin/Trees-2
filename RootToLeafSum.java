// Time Complexity : O(n)
// Space Complexity : O(h) recursive
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RootToLeafSum {
    public class TreeNode {
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
    int totalSum;

    public int sumNumbers(TreeNode root) {
        totalSum =0;
        sumNumbersHelper(root, 0);
        return totalSum;
    }

    public void sumNumbersHelper(TreeNode root, int currSum) {
        if(root == null) {
            return;
        }
        // Finding the currSum for each node
        currSum = currSum*10 +root.val;
        if(root.right == null && root.left==null) {
            // when reached at the leaf node, we are adding it to global totalSum
            totalSum+=currSum;
        }
        // call on left and right subtree
        sumNumbersHelper(root.left, currSum);
        sumNumbersHelper(root.right, currSum);
    }
}
