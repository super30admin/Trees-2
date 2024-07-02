// Time Complexity : O(n) => As we are iterating over the n nodes
// Space Complexity : O(h) => Even though we don't use explicit stack we are using recursive stack to store the nodes which can go up to the height 'h' of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: This solution uses recursive way where first we calculate sum of left nodes by multiplying the current num*10 and adding the current root value. This process is repeated for all the right nodes as well. For all the leaf nodes thatn finally add the current summ and the leaf's node value to the sum defined class level
 */
class Solution {
    int sum;

    public int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }

        sum = 0;
        recurse(root, 0);

        return sum;
    }

    private void recurse(TreeNode root, int num) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum = sum + num * 10 + root.val;
        }

        recurse(root.left, num * 10 + root.val);

        recurse(root.right, num * 10 + root.val);
    }
}