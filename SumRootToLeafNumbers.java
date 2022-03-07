// Time Complexity : O(n) ~ computing for all nodes reaching till the leaf node.
// Space Complexity : Implicit stack O(n) ~ O(h) h - height of tree, when the tree is skewed but it is O(1) if recursion stack ignored because using only constant variables
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/655358650/)
// Any problem you faced while coding this : No
// My Notes : Idea is to Recursive traversal and then check if we reach the leaf node. To know the leaf node, we check the left and right child to be null and then add to the global sum.

class Solution {

    // Global sum
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        int subList = 0;
        preOrder(root, subList);
        return sum;
    }

    // Doing preorder traversal, checking root then left followed by right.
    private TreeNode preOrder(TreeNode root, int subList) {
        if (root == null) {
            return null;
        }
        // Multiplying the number by 10 to increase the tens position and add the new node val
        subList = subList * 10 + root.val;
        // If leaf node encounterd then add to the global sum
        if (root.left == null && root.right == null) {
            // System.out.println(subList);
            sum += subList;
        }
        preOrder(root.left, subList);
        preOrder(root.right, subList);
        return null;
    }

}