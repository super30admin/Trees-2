// ## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

// Time Complexity : O(N)
// Space Complexity : O(Height of Tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A

// 2. Iterative
// Your code here along with comments explaining your approach
// Do an iterative preorder traversal and maintian the current path sum
// if we reach a leaf node, add it to the global sum

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

 // Iterative: TO(N); SO(H)
 class Solution {
    public int sumNumbers(TreeNode root) {
        int totalSum=0;
        Stack<TreeNode> stNodes = new Stack<>();
        Stack<Integer> stSum = new Stack<>();

        //add root
        stNodes.push(root);
        stSum.push(0);

        while(!stNodes.isEmpty()){
            // get curr node
            TreeNode currN = stNodes.pop();
            int currPathSum = stSum.pop()*10 + currN.val;

            //process curr node
            if(currN.left==null && currN.right==null){
                //leaf node
                totalSum += currPathSum;
            }

            //push right and left nodes
            if(currN.right!=null){
                stNodes.push(currN.right);
                stSum.push(currPathSum);
            }
            if(currN.left!=null){
                stNodes.push(currN.left);
                stSum.push(currPathSum);
            }
        }

        return totalSum;
    }
}
