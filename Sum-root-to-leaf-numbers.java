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
    //global var
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return sum;
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int currSum){
        //base
        if(root == null) return ;

        //logic
        currSum = currSum*10 + root.val;
        //leaf
        if(root.left==null && root.right==null){
            sum += currSum;
        }

        //left
        helper(root.left, currSum);
        //right
        helper(root.right, currSum);

    }
}