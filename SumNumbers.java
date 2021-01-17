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
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int currSum){
        //base
        if(root == null) return;
        if(root.left == null && root.right == null){
            result += currSum * 10 + root.val;
        }
        //logic
        currSum = currSum * 10 + root.val;
        helper(root.left,currSum);
        helper(root.right, currSum);
    }
    
}

/*
Each node stores the path up to that point. 
Sum gets affected if it is global, so we need to store it locally.
Time Complexity : O(N), because we visit each node exactly once. 
Space Complexity: O(H), where h is height;
*/

