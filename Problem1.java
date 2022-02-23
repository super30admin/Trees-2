// Time Complexity : O(n) where n = number of nodes in the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

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

public class Problem1 {
    
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private static TreeNode buildTree(int[] inorder, int[] postorder, int inorderStartIndex, int inorderEndIndex, int postorderStartIndex, int postorderEndIndex ) {
        // if inorderStartIndex > inorderEndIndex or postorderStartIndex > postorderEndIndex, return null
        if (inorderStartIndex > inorderEndIndex || postorderStartIndex > postorderEndIndex) {
            return null;
        }
        // Since value at end index of postorder array is the value of root, create a root node with that value
        TreeNode root = new TreeNode(postorder[postorderEndIndex]);
        // Search for the root value in the inorder array to get index of root in the inorder array
        int inorderRootIndex = -1;
        for (int i = inorderStartIndex; i <= inorderEndIndex; i++) {
            if (inorder[i] == postorder[postorderEndIndex]) {
                inorderRootIndex = i;
                break;
            }
        }
        // Find root of left subtree
        TreeNode left = buildTree(inorder, postorder, inorderStartIndex, inorderRootIndex-1, postorderStartIndex, postorderStartIndex + inorderRootIndex - inorderStartIndex - 1);
        // Find root of right subtree
        TreeNode right = buildTree(inorder, postorder, inorderRootIndex+1, inorderEndIndex, postorderStartIndex + inorderRootIndex - inorderStartIndex, postorderEndIndex-1);
        // Root of left subtree is left child of main root
        root.left = left;
        // Root of right subtree is right child of main root
        root.right = right;
        // Return root
        return root;
    }

    // Function to print the binary tree
    public static List<Integer> printTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
          return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                res.add(null);      
            } else {
                q.add(curr.left);
                q.add(curr.right);
                res.add(curr.val);
          }
        }
        int i = res.size()-1;
        while (res.get(i) == null) {
            res.remove(i--);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3}, inorder = {9,3,15,20,7};
        TreeNode root = buildTree(inorder, postorder);
        List<Integer> ans = printTree(root);
        System.out.println(ans);
    }
}
