// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Had to learn

/*
 * In order will give you what is left vs right
 * PostOrder will give us the head or root node.
 * 
 * It is different from preorder -> we have to take both inStart, inEnd & postStart, postEnd
 * 
 * instart, inEnd is similar to preorder but we have to determine the postStart & postEnd based of the length of the leftElements.
 * 
 * Properties:
 */

import java.util.*;

public class ConstructBinaryTree_InvsPost {

    Map<Integer, Integer> cache = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            cache.put(inorder[i], i);
        }

        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode();
        root.val = postOrder[postEnd];
        int indexOfRootInOrder = cache.get(root.val);
        int numOfItemsToLeft = indexOfRootInOrder - inStart;

        root.left = helper(inorder, inStart, indexOfRootInOrder - 1, postOrder, postStart,
                postStart + numOfItemsToLeft - 1);
        root.right = helper(inorder, indexOfRootInOrder + 1, inEnd, postOrder, postStart + numOfItemsToLeft,
                postEnd - 1);

        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        // Should i use HashMap? Should I use a different function? - Not for this
        // solution.
        if (inorder.length == 0)
            return null;

        int rootVal = postorder[postorder.length - 1];
        int indx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                indx = i;
                break;
            }
        }

        int[] inOrderL = Arrays.copyOfRange(inorder, 0, indx);
        int[] inOrderR = Arrays.copyOfRange(inorder, indx + 1, inorder.length);

        // New property: The indx will hold the length of left
        // 0 -> indx-1 will give left subarray ; indx -> postorder.length-2 would give
        // the right subarray
        int[] postorderL = Arrays.copyOfRange(postorder, 0, indx);
        int[] postOrderR = Arrays.copyOfRange(postorder, indx, postorder.length - 1);

        TreeNode rootNode = new TreeNode();
        rootNode.val = rootVal;
        rootNode.right = buildTree(inOrderR, postOrderR);
        rootNode.left = buildTree(inOrderL, postorderL);

        return rootNode;

    }
}