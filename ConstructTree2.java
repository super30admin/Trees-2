package com.ds.rani.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note: You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * inorder = [9,3,15,20,7]
 * <p>
 * postorder = [9,15,7,20,3] Return the following binary tree:
 * <p>
 * 3
 * <p>
 * / \
 * <p>
 * 9 20
 * <p>
 * /  \
 * 15 7
 */

//Approach recursively build tree, by finding root in postorder array, then root for left subtree,root for right subtree
//Time Complexity:o(n) where n is number of nodes
//Space Complexity:o(1)
public class ConstructTree2 {
    /**
     * TreeNode class
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        //create Map for reducing time complexity of serching root position in inorder arry
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++)
            map.put( inorder[i], i );

        return helper( inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map );

    }

    /**
     * Helper function to recursively build tree
     *
     * @param inorder   inorder array
     * @param postorder postorder array
     * @param inStart   start index in inorder array
     * @param inEnd     end  index in inorder array
     * @param postStart start index in post order array
     * @param postEnd   end index in postorder array
     * @param map       map of elemnts from in order array
     * @return root of the tree
     */
    static TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootNum = postorder[postEnd];
        //Find the position of root elemnt in inorder array
        int rootIdx = map.get( rootNum );

        //create root node
        TreeNode root = new TreeNode( rootNum );
        root.left = helper( inorder, postorder, inStart, rootIdx - 1, postStart, postStart + rootIdx - inStart - 1, map );
        root.right = helper( inorder, postorder, rootIdx + 1, inEnd, postStart + rootIdx - inStart, postEnd - 1, map );

        return root;

    }

}

