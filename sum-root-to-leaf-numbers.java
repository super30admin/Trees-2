// Time Complexity :O(n) n is the number of nodes
// Space Complexity :O(h) h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

class Solution {
    public int sumNumbers(TreeNode root) {
        return inorder(root, 0);
    }

    private int inorder(TreeNode root, int sum) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return sum * 10 + root.val;
        int left = inorder(root.left, sum * 10 + root.val);
        int right = inorder(root.right, sum * 10 + root.val);
        return left + right;
    }
}