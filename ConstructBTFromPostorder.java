// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Coming up with logic to build the left subtree

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    // Map to store the indices of values in the inorder traversal array
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    // Method to build the binary tree from inorder and postorder traversal arrays
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Populate the inorder map for quick access
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Call the recursive method to split and build the tree
        return splitTree(postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode splitTree(int[] postorder, int rootIdx, int left, int right) {

        // Base case: if left index exceeds right index, return null
        if (left > right) {
            return null;
        }

        // Create a new TreeNode with the current root value
        TreeNode root = new TreeNode(postorder[rootIdx]);

        // Find the index of the root value in the inorder array
        int mid = inorderMap.get(postorder[rootIdx]);

        // Recursively construct the right and left subtree
        root.left = splitTree(postorder, rootIdx - (right - mid) - 1, left, mid - 1);
        root.right = splitTree(postorder, rootIdx - 1, mid + 1, right);

        return root;
    }
}