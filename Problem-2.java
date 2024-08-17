// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english: I used the same logic Jaspinder explained. 


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
        return helper(root, 0);
    }

    public int helper(TreeNode root, int curNum){
        if(root == null) return 0;
        curNum = curNum * 10 +root.val;
        // check for leaf
        if(root.left == null && root.right == null){
            return curNum;
        }
        return helper(root.left, curNum) + helper(root.right, curNum);
    }

    // public void helper(TreeNode root, int curNum){
    //     if(root == null) return;
    //     curNum = curNum * 10 +root.val;
    //     // check for leaf
    //     if(root.left == null && root.right == null){
    //         result += curNum;
    //     }
    //     helper(root.left, curNum);
    //     helper(root.right, curNum);


    // }



    // public int preOrder(TreeNode node, int sum){
    //     if(node == null ) return 0;

    //     sum = sum * 10 + node.val;

    //     if(node.left == null && node.right == null) return sum;

    //     return preOrder(node.left, sum) + preOrder(node.right, sum);

        
    // }
}