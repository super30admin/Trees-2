// Time Complexity : O(N) - N is the number of nodes in the tree
// Space Complexity : O(N) - As we are using recursion recursion stack occupies space of O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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

 //Using a helper function to calculate the totalsum
 //using a currsum to consider each element and then adding it up to the totalsum when leaf node is reached
class Solution {
    int totalsum = 0;
    public void helper(TreeNode root,int currsum){
        if(root == null) return;
        if(root.left == null && root.right == null){
            totalsum = totalsum + (currsum * 10 + root.val);
        }
        currsum = currsum * 10 + root.val;
        helper(root.left,currsum);
        helper(root.right,currsum);
        
    }
    public int sumNumbers(TreeNode root) {
        helper(root,totalsum);
        
        return totalsum;
    }
}

// Your code here along with comments explaining your approach