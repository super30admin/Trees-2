/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /* 
        TC - O(n)
        SC - O(h)

        This solution usespreorder traversal to calculate the sum of all root-to-leaf numbers. Starting from the root, 
        we build the current number by multiplying the previous value by 10 and adding the current node's value.
        When a leaf node is reached (a node with no left or right child), the complete number formed along that path 
        is added to the total sum. The recursion continues for both the left and right children, carrying the current 
        number along each path. After all root-to-leaf paths are explored, the total sum is returned
    */
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int curSum) {
        if (root != null) {
            curSum = curSum * 10 + root.val;
            if (root.left == null && root.right == null) {
                sum += curSum;
            }
            helper(root.left, curSum);
            helper(root.right, curSum);
        }
    }
}