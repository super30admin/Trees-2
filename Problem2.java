// Time Complexity : O(n) - For iterating over all the elements of tree
// Space Complexity : O(1) - not using any extra space 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        
        // Calling helper function
        return sum(root, 0);
    }
    
    public int sum(TreeNode node, int val){
        
        //Checking base condtion
        if(node == null){
            return 0;
        }
        
        // calculating value at each node
        val = (val*10 + node.val);
        
        // checking is we reached the leaf node, then the val will be the number formed for that path
        if(node.left == null && node.right == null){
            return val;
        }
        
        //calling helper function recursively and adding sum of left and right and returning the answer
        return sum(node.left, val) + sum(node.right, val);
    }
}