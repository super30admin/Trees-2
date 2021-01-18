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
        if(root == null)
            return 0;
        helper(root,0);
        return result;
    }
    public void helper(TreeNode root,int currSum){
       //base 
        if(root == null) return;
        //logic
        currSum = currSum * 10 +  root.val;
        helper(root.left,currSum);
        //st.pop() happens when we go left left left
        if(root.left==null && root.right == null)
            result += currSum;
        helper(root.right,currSum);
    }
}

//recursive solution
//Time complexity: O(n) since we are reaching the leaf node atleast once
//Space Complexiyt: O(h) where h is the height of the tree
