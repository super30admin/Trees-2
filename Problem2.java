//Method 1:Bruteforce approach
// Time Complexity :O(N)
// Space Complexity :O(h) Height of tree from root to leaf
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
//TC:O(N)
//SC:O(h) where is the height from root to leaf;
class Solution {
    int res_sum;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        inorder(root,0);
        return res_sum;
    }
    private void inorder(TreeNode root,int temp_sum){
        if(root==null) return;
        temp_sum=temp_sum*10+root.val;
        inorder(root.left,temp_sum);
        if(root.left==null&&root.right==null)res_sum+=temp_sum;
        inorder(root.right,temp_sum);

    }
}