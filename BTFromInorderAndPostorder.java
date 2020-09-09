// Time Complexity : O(N x N) as we will have to go array N times for each N.
// Space Complexity : O(N) as we will create arrays at each recursion.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Similar to inorder and pre-order problem.

import java.util.*;

public class BTFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0) {
            return null;
        }
        
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        
        int index = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        
        int[] in_left = Arrays.copyOfRange(inorder, 0, index);
        int[] post_left = Arrays.copyOfRange(postorder, 0, index);
        
        int[] in_right = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] post_right = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        
        root.left = buildTree(in_left, post_left);
        root.right = buildTree(in_right, post_right);
        
        return root;
    }

    /* Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
