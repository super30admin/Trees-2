//  Time Complexity: o(n) where n is the number of nodes in the tree
//  Space Complexity: O(h) where h is the height of the tree (due to recursion stack)
//  Did this code successfully run on Leetcode: Yes
//  Any problem you faced while coding this: No 
//  Three line explanation of solution in plain english:
//  1. We recursively calculate the sum of all root-to-leaf numbers in the binary tree.
//  2. We maintain a current sum as we traverse the tree, multiplying it by 10 and adding the current node's value.
//  3. When we reach a leaf node, we add the current sum to the result.



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
    //result is the global variable, since we store the sum of all paths
    int res=0;
    public int sumNumbers(TreeNode root) {
        //we call the void based recursive function to calculate the sum of all root-to-leaf numbers
        //starting with a current sum of 0
        calculateSum(root,0);
        //return the result of the sum of all root-to-leaf numbers
        return res;
        
    }
    private void calculateSum(TreeNode root,int currSum){
        //if the root is null, we return
        //this is the base case for the recursion
        if (root==null) return;
        //we multiply the current sum by 10 and add the current node's value to append the digits of the tree node
        currSum=currSum*10+root.val;
        //once we reach a leaf node, we add the current sum to the result
        //a leaf node is a node with no left or right child
        if (root.left==null && root.right==null){
            res+=currSum;
        }
        //we recursively call the function for the left and right child of the current node
        calculateSum(root.left,currSum);
        calculateSum(root.right,currSum);
    }
}