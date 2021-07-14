//129. Sum Root to Leaf Numbers - https://leetcode.com/problems/sum-root-to-leaf-numbers/

// Time Complexity : O(N) no. of node
// Space Complexity : O(H) height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Time Complexity : O(N) no. of node
// Space Complexity : O(H) height
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
class Pair
{
    TreeNode root;
    int sum;
    
    public Pair(TreeNode root, int sum){
        this.root=root;
        this.sum=sum;
    }
    public TreeNode getKey(){
        return this.root;
    }
    public int getValue(){
        return this.sum;
    }
}
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        
        helper(root,0);
        return result;
    }
    
    private void helper(TreeNode root, int currSum){
        // base 
        if(root==null) return;
        // logic
        currSum = currSum * 10 + root.val;
        helper(root.left, currSum);
        if(root.left==null && root.right==null){
            result+=currSum;
        helper(root.right, currSum);
        }      
    }
}