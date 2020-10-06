// Time Complexity: O(n)
// Space Complexity: O(n)
// Does it work on Leetcode: Yes
// A more space efficient algo is using the morris preorder traversal which gives it a O(1). This is quite long to and probably not efficient for an interview 
// This problem was a little more complex for me. I did look up the answers and found this clean and concise problem. It really helpedf me understand the problem. 
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
    public int sumNumbers(TreeNode root) {
        
        return sum(root, 0);
    }
    public int sum(TreeNode n ,int s) {
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sum(n.left, s*10 + n.val) + sum(n.right, s*10 + n.val);
    }
}
