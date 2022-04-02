/*
// Time Complexity : O(n) where n is the eleements in the tree
// Space Complexity : O(h) where h is the height of the tree.
// Did this code successfully run on Leetcode : Yes

*/
public class sumtoleaf {

    int sum;

    public int sumNumbers(TreeNode root) {

        if (root == null)
            return sum;

        helper(root, 0);
        return sum;

    }

    public void helper(TreeNode root, int num) {

        // base condition
        if (root == null)
            return;
        // condition to use number
        num = num * 10 + root.val;
        helper(root.left, num);
        // condition to add num into the sum
        if (root.left == null && root.right == null) {

            sum += num;
        }

        helper(root.right, num);
    }
}
