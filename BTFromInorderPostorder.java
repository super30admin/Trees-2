// Approach: The last element of the postorder traversal is always the root. Find the index of this element in the inorder traversal.
// All elements to the left of this index form the left subtree, and all elements to the right form the right subtree. Recursively
// construct the entire tree while keeping track of the start and end indices of the postorder and inorder traversals for each subtree.
// Time Complexity: O(n) where n - node count
// Space Complexity: O(n) for hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

import java.util.Map;
import java.util.HashMap;

public class BTFromInorderPostorder {

    private Map<Integer, Integer> inMap;

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) {
            val = v;
        }
    }

    TreeNode construct(int[] inorder, int[] postorder) {
        inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIdxInorder = inMap.get(postorder[postEnd]);
        int leftSubtreeNodeCount = rootIdxInorder - inStart;
        root.left = build(inorder, inStart, rootIdxInorder - 1, postorder, postStart, postStart + leftSubtreeNodeCount - 1);
        root.right = build(inorder, rootIdxInorder + 1, inEnd, postorder, postStart + leftSubtreeNodeCount, postEnd - 1);
        return root;
    }

    void traversePostorder(TreeNode root) {
        if (root == null) {
            return;
        }
        traversePostorder(root.left);
        traversePostorder(root.right);
        System.out.print(root.val + ", ");
    }

    public static void main(String[] args) {
        BTFromInorderPostorder btfip = new BTFromInorderPostorder();
//        inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        TreeNode root = btfip.construct(inorder, postorder);
        btfip.traversePostorder(root); // prints 9, 15, 7, 20, 3
        System.out.println();
    }
}