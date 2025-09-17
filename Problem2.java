// 129. Sum Root to Leaf Numbers
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
 /*
Ran on leetcode: Yes
TC: O(n)
SC: O(n)
Traverse DFS and calculate the path to each leaf node and add it to result
 */
class Solution {

    private int result;

    public int sumNumbers(TreeNode root) {
        this.result = 0;
        helper(root, 0);
        return result;    
    }

    public void helper(TreeNode root, int pathSum){
        
        // base case
        if(root == null){
            return;
        }

        // logic
        // current path
        pathSum = 10 * pathSum + root.val;

        // reached leaf add the path to the result
        if(root.left == null && root.right == null){
            result += pathSum;
            return;
        }
        
        // traverse left subtree
        helper(root.left, pathSum);
        // traverse right subtree
        helper(root.right, pathSum);
    }
}