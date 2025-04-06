//Time Complexity : O(n) for the hashmap + O(n) for the recursion
//Space Complexity : O(n) for the hashmap + O(n) for the recursion stack

/**
 * Builds a binary tree from inorder and postorder traversal arrays.
 * The buildTree method initializes the recursive process by setting the postorder index 
 * and building a map for the inorder array to optimize search.
 */

 //LeetCode: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

import java.util.HashMap;

public class ConstructBinaryTreeFromPostOrderInOrder {
     // Definition for a binary tree node.
    class TreeNode {
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

    int postIndex; 

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postIndex = postorder.length -1; 
        HashMap<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return helper(postorder,inOrderMap, 0, inorder.length-1);
    }
    public TreeNode helper(int[] postOrder, HashMap<Integer, Integer> inOrderMap, 
        int inStart, int inEnd) {
        if (inStart > inEnd)
        return null;

        // The current root node value is at postOrder[postIndex]
        TreeNode root = new TreeNode(postOrder[postIndex]);

        // Get the root's index in the inorder traversal
        int inOrderindex = inOrderMap.get(root.val);

        // Decrement postIndex for the next recursive call, after processing the root
        postIndex--;

        // First build the right subtree, because we are processing postorder from the end
        root.right = helper(postOrder, inOrderMap, inOrderindex + 1, inEnd);

        // Then build the left subtree
        root.left = helper(postOrder, inOrderMap, inStart, inOrderindex - 1);

        return root;
    }
    
}
