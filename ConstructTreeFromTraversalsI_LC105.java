/**
 * We know for sure that first element from preorder traversal is the root node and thus use that to identify left
 * and right part of tree from inorder array. Once we know the separation point, same length separation is followed by
 * preorder traversal
 * Form left and right inorder and preorder sub trees and iterate recursively util arrays are exhausted
 */
// Time Complexity: O (N) N: number of nodes in tree; Asymptotically
// Space Complexity: O (N) Space asymptotically and O(H) stack space for recursion where H is tree height
// Did this code successfully run on Leetcode : Yes
import java.util.Arrays;

public class ConstructTreeFromTraversalsI_LC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);      // First index in preorder is root

        int sepIndex = -1;                              // Find left right separation point as root is found
        for (int i = 0; i < inorder.length; i++)
            if (inorder[i] == root.val) {
                sepIndex = i;
                break;
            }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, sepIndex);
        int[] inRight = Arrays.copyOfRange(inorder, sepIndex + 1, inorder.length);

        int[] preLeft = Arrays.copyOfRange(preorder, 1, sepIndex + 1);
        int[] preRight = Arrays.copyOfRange(preorder, sepIndex + 1, preorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;

    }
}
