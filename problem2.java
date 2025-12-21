// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
Appraoch
we are using DFS preorder traversal,one each itterate we add the num to sum
when we hit the leaf node we add the sum to result 
 */
class Solution {
    int result;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return result;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null)
            return;

        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += sum;
        }
        helper(root.left, sum);
        helper(root.right, sum);

    }

}