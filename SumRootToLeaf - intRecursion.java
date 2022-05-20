
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

 //preorder
 class Solution {
    public int sumNumbers(TreeNode root) {
        int sum =0;
        sum += helper(root, 0);
        return sum;
    }
    
    private int helper(TreeNode root, int curr_sum){
        if(root==null){
            return 0;
        }        
        
        if(root.left==null && root.right==null){
            curr_sum = curr_sum*10 + root.val;
            return curr_sum;
        }
        return helper(root.left, curr_sum*10 + root.val) + helper(root.right, curr_sum*10 + root.val);        
    }
}


//inorder
class Solution {
    int sum =0;
    public int sumNumbers(TreeNode root) {
        sum += helper(root, 0);
        return sum;
    }
    
    private int helper(TreeNode root, int curr_sum){
        if(root==null){
            return 0;
        }        
        int left = helper(root.left, curr_sum*10 + root.val);
        if(root.left==null && root.right==null){
            curr_sum = curr_sum*10 + root.val;
            return curr_sum;
        }
        return  left + helper(root.right, curr_sum*10 + root.val);        
    }
}

//postorder
class Solution {
    int sum =0;
    public int sumNumbers(TreeNode root) {
        sum += helper(root, 0);
        return sum;
    }
    
    private int helper(TreeNode root, int curr_sum){
        if(root==null){
            return 0;
        }        
        int left = helper(root.left, curr_sum*10 + root.val);
        int right = helper(root.right, curr_sum*10 + root.val);  
        if(root.left==null && root.right==null){
            curr_sum = curr_sum*10 + root.val;
            return curr_sum;
        }
        return  left + right;
    }
}
