//Time Complexity: O(N) where N is the number of nodes in the tree
//Space Complexity: O(h) where h is the height of the tree and if we consider recursive stack space
//Successfully runs on leetcode: 0ms

//Approach: We recursively traverse, first the left subtree and store the local total at each node and when we reach the leaf
//node, we add the local sum in the final result and similarly, we perform recursive sum on right subtree and add it in the 
//result.



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
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return sum;
    }
    
    private void helper(TreeNode root, int total)
    {
        //base
        if(root == null) return;
        
        //logic
        total = total * 10 + root.val;
        helper(root.left, total);
        if(root.left == null && root.right == null)
        {
            sum+= total;
        }
        helper(root.right, total);
    }
}