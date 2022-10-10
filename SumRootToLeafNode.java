// Time Complexity : O(N) n is # of elements in tree
// Space Complexity : O(h) h is height of the tree - stack will be crated for recurssive calls
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;

        dfs(root, 0);

        return sum;
    }

    private void dfs(TreeNode root, int num) {
        //base
        if(root == null) return;

        //logic

        //to check if the node is leaf node
        if(root.left == null && root.right == null){
            sum = sum + num*10 + root.val;
            return;
        }

        dfs(root.left, num*10+root.val);
        dfs(root.right, num*10+root.val);
    }
}