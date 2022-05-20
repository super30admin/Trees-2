// Time Complexity : O(h) - height of tree
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no
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

//PreOrder
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    
    private void helper(TreeNode root, int curr_sum){
        if(root==null){
            return;
        }        
        curr_sum = curr_sum*10 + root.val;
        if(root.left==null && root.right==null){
            sum += curr_sum;
        }
        System.out.println("stack- root_val- "+root.val+" curr_sum- "+curr_sum);
        helper(root.left, curr_sum);
        helper(root.right, curr_sum);
    }
}


//InOrder
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    
    private void helper(TreeNode root, int curr_sum){
        if(root==null){
            return;
        }        
        helper(root.left, curr_sum);
        System.out.println("stack with left- root_val- "+root.val+" curr_sum- "+curr_sum);
        curr_sum = curr_sum*10 + root.val;
        if(root.left==null && root.right==null){
            sum += curr_sum;
        }
        System.out.println("stack- root_val- "+root.val+" curr_sum- "+curr_sum);
        helper(root.right, curr_sum);
        
    }
}

//PostOrder
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    
    private void helper(TreeNode root, int curr_sum){
        if(root==null){
            return;
        }        
        helper(root.left, curr_sum);
        System.out.println("stack- root_val- "+root.val+" curr_sum- "+curr_sum);
        helper(root.right, curr_sum);
        curr_sum = curr_sum*10 + root.val;
        if(root.left==null && root.right==null){
            sum += curr_sum;
        }
    }
}