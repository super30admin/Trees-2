// Leetcode Problem : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Last element of postorder is the root. The elements to the left of the root in the inorder traversal form the left subtree of the root and the
 * elements to the right side of the root form the right subtree. I use this concept recursively to build the tree. Base Condition : If postorder.length==0, return null. 
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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0)
        {
            return null;
        }
        int rootVal = postorder[postorder.length-1];
        int index = -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal)
            {
                index=i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int inorderleft[] = Arrays.copyOfRange(inorder,0,index);
        int inorderright[] = Arrays.copyOfRange(inorder,index+1,inorder.length);
        int postorderleft[] = Arrays.copyOfRange(postorder,0,inorderleft.length);
        int postorderright[] = Arrays.copyOfRange(postorder,postorderleft.length,postorder.length-1);
        root.left = buildTree(inorderleft,postorderleft);
        root.right = buildTree(inorderright,postorderright);
        return root;
    }
}

