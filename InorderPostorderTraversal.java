// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class InorderPostorderTraversal {
     private HashMap<Integer, Integer> inorderMap;
    private int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        
        // Store inorder values with their indices for quick lookup
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        postIndex = postorder.length - 1; // Start from the last element in postorder

        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
    
    }
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        // Get the current root value from postorder traversal
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Get the index of the root in inorder traversal
        int inorderIndex = inorderMap.get(rootVal);

        // Build right subtree first (since postorder is L-R-Root)
        root.right = buildTreeHelper(inorder, postorder, inorderIndex + 1, inEnd);
        // Build left subtree
        root.left = buildTreeHelper(inorder, postorder, inStart, inorderIndex - 1);

        return root;
    }
}
