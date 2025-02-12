# Trees-2

## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
## solution
class Solution {
    private int postIndex; // Tracks the current root index in postorder

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1; // Start from the last element of postorder
        return constructTree(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] inorder, int[] postorder, int left, int right) {
        if (left > right) return null; // Base case: no elements to construct

        // Get root value from postorder and move index left
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder (O(N) search)
        int inorderIndex = findIndex(inorder, rootVal, left, right);

        // **Build right subtree first** (since postorder is L-R-Root)
        root.right = constructTree(inorder, postorder, inorderIndex + 1, right);
        root.left = constructTree(inorder, postorder, left, inorderIndex - 1);

        return root;
    }

    // Helper function to find index of a value in inorder
    private int findIndex(int[] inorder, int target, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == target) return i;
        }
        return -1; // Should never happen since inputs are valid
    }
}



## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)
## solution  
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int curr) {
        if (root == null) return 0;

        // Correct number formation
        curr = curr * 10 + root.val;

        // If it's a leaf node, return the number formed
        if (root.left == null && root.right == null) {
            return curr;
        }

        // Recursive call for left and right children
        return helper(root.left, curr) + helper(root.right, curr);
    }
}
