// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


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

        sum = 0;
        if(root == null) return sum;
        dfs(root, root.val);
        return sum;
    }
    private void dfs(TreeNode root, int rootValue){

        //base
        if(root == null) return;
        if(root.left == null && root.right == null){
            sum += rootValue;
            return;
        }

        //logic
        if(root.left != null)
            dfs(root.left, rootValue * 10 + root.left.val);
        if(root.right != null)
            dfs(root.right, rootValue * 10 + root.right.val);
        return;
    }
}