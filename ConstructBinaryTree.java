// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

// Example 1:
// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]

// Example 2:
// Input: inorder = [-1], postorder = [-1]
// Output: [-1]
 
// Constraints:
// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder and postorder consist of unique values.
// Each value of postorder also appears in inorder.
// inorder is guaranteed to be the inorder traversal of the tree.
// postorder is guaranteed to be the postorder traversal of the tree.

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

import java.util.HashMap;

class Solution {

    private HashMap<Integer, Integer> inorderIndexMap;
    private int postorderIndex; // Pointer to track current position in postorder array (moves right to left)

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Base case: If the array is empty, return null
        if (inorder == null || inorder.length == 0){
            return null;
        }

        // Building HashMap
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        // Starting from the last element in postorder (which is the root)
        postorderIndex = postorder.length - 1;

        // Building tree recursively using index boundaries
        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }

    // Recursive helper function that builds tree using index boundaries
    private TreeNode buildTreeHelper(int[] postorder, int inorderStart, int inorderEnd){
        // Base case: invalid boundaries means no subtree exists
        if (inorderStart > inorderEnd){
            return null;
        }

        // Current root is at postorderIndex (we process postorder from right to left)
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Finding root's position in inorder array
        int rootIndex = inorderIndexMap.get(rootVal);

        // KEY INSIGHT: In postorder, we process RIGHT subtree before LEFT subtree
        // because postorder is: [left] [right] [root]
        // When we go backwards, we encounter: [root] [right] [left]
        
        // Recursively building RIGHT subtree first (everything after root in inorder)
        root.right = buildTreeHelper(postorder, rootIndex + 1, inorderEnd);

        // Then building LEFT subtree (everything before root in inorder)
        root.left = buildTreeHelper(postorder, inorderStart, rootIndex - 1);

        return root;
    }
}
