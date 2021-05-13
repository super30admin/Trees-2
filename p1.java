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
//time-o(n2)-traverse through array, search array for every root node in pre-order
//space-o(n2)-
///passed in leetcode-yes

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       
        if(preorder.length==0) return null;
        int in_index =0;//inorder root
     
        for(int i=0;i<inorder.length;i++)//o(n)
        {
            if(inorder[i]==preorder[0])
            {
                in_index= i;
            }
        }
        TreeNode root= new TreeNode(preorder[0], null, null); //create root, with current pre-order root val

        int[] pre_left= Arrays.copyOfRange(preorder, 1 , in_index+1 );//pre-order left array will be starting from 1st element, till the idex+1, as till indx 1, in inorder array, is left subtree
        int[] pre_right= Arrays.copyOfRange(preorder, in_index+1 , preorder.length);
        int[] in_left= Arrays.copyOfRange(inorder, 0 , in_index);
        int[] in_right= Arrays.copyOfRange(inorder, in_index+1 , inorder.length);
        
        root.left = buildTree(pre_left,in_left);
        root.right = buildTree(pre_right,in_right);
        
        return root;
    }
}