// Sum of root to leaf numbers
//TimeComplexity: O(n)
//Space Complexity: O(1)
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
        int sum ;
    public int sumNumbers(TreeNode root) {
    

        helper(root,0);
        return sum;
        
    }

    public void helper(TreeNode root , int currentNum){

        if(root == null) { return;}

        currentNum = currentNum * 10 + root.val;

        if(root.left == null && root.right == null) {
            sum = sum + currentNum;
        }

        helper(root.left, currentNum);
        helper(root.right, currentNum);
        
    }
}
