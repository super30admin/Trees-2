// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I used the property of preorder traversal of array - first element of preorder traversal is the root element and inorder traversal - 
 * elements to left of root belong to left subtree and elements to right of root belong to right subtree to recursively create the tree.
 */

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
class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
        {
            return null;
        }
        int val = preorder[0];
        TreeNode root = new TreeNode(val);
        int index=-1;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==val)
            {
                index=i;
            }
        } 
        int []inorderLeft = Arrays.copyOfRange(inorder,0,index);
        int []inorderRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int []preorderLeft = Arrays.copyOfRange(preorder,1,inorderLeft.length+1);
        int []preorderRight = Arrays.copyOfRange(preorder,index+1,preorder.length);

        root.left=buildTree(preorderLeft,inorderLeft);
        root.right=buildTree(preorderRight,inorderRight);
        return root;
    }
}