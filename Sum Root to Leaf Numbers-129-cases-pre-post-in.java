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
 // Time Complexity : O(n) where n is number of elements in the tree
 // Space Complexity: O(h) where h is the height of the tree
class Solution {
    // Global variable
    //int sum = 0;
    public int sumNumbers(TreeNode root) {
        // if root is null return 0
        if(root == null)
        {
            return 0;
        }
        return inorder(root, 0);
        //return sum;  
    }

// Recursive method to get the sum
    private int inorder(TreeNode root, int currSum)
    {
        if(root ==null)
        {
            return 0;
        }
        int case1 = inorder(root.left, currSum*10+root.val);
        // Inorder
        // if leaf node is reached then add it to the sum
        if(root.left==null && root.right==null)
        {
            return currSum*10+root.val;
        }  
        int case2 = inorder(root.right, currSum*10+root.val);  
        return case1+case2;
        
    }
}

