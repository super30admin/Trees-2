/*
 * Time Complexity : O(n)
 * Space Complexity :  O(h)
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
 * 
 * Approach - We start at the root element and recursively traverse through the tree. At each call we pass the left child/right child and the current sum value for that node. For every node
 * we multiply the current sum with 10 and add the node value. Once we reach the end of the path, we return the current sum.
 */

//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

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

class SumRootToLeaf {
    int res;
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currSum){
        if(root==null){
            return 0;
        }
        currSum = currSum*10 + root.val;
        if(root.left==null && root.right==null){
            return currSum;
        }

        return helper(root.left, currSum) + helper(root.right,currSum);
    }
}