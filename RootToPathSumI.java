package BST;// Time Complexity : O(n)
// Space Complexity : O(h) h is the height of the tree
// Did this code successfully run on Leetcode : Yes

public class RootToPathSumI {
    int result;

    public int sumNumbers(TreeNode root) {

        helper(root, 0);
        return result;

    }

    public void helper(TreeNode root, int curSum) {

        if (root == null) return;
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            result = result + curSum;
        }

        helper(root.left, curSum);
        helper(root.right, curSum);

    }

    /*public int helper(TreeNode root, int curSum){ //int based recurssion

        if(root == null) return 0;
        curSum = curSum*10 + root.val;
        if(root.left == null && root.right == null)
        {
            return curSum;
        }

        int left = helper(root.left, curSum);
        int right = helper(root.right, curSum);

        return left+right;*/

}