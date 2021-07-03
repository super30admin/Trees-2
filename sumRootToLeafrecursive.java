//time complexity O(n)
//space complexity O(1)

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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int sum){
        //base
        if(root == null) return;

        if(root.left == null && root.right == null){
            result += sum * 10 + root.val;
        }

        //logic
        helper(root.left, sum * 10 + root.val);
        helper(root.right, sum * 10 + root.val);
    }
}
