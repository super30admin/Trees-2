// // Time Complexity : O(n) 
// // Space Complexity : O(n) n = no of nodes in BST
// // Did this code successfully run on Leetcode : Yes
// // Any problem you faced while coding this : No

// // Your code here along with comments explaining your approach
// //1. Inorder Traversal is LEFT, ROOT, RIGHT and preorder traversal is ROOT, LEFT, RIGHT
// //2. When postorder traversal is given we have the root node of the tree at the last index.
// //3. By keeping track of index we can traverse the inorder and postorder array and build a BST.
import java.util.*;

public class InorderPostorder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || postorder == null)
            return null;

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length - 1);

        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);

        return root;

    }

    void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {

        InorderPostorder obj = new InorderPostorder();
        int[] postorder = { 8, 7, 4, 3, 18, 1, 9, 10 };
        int[] inorder = { 8, 4, 7, 10, 3, 9, 1, 18 };
        TreeNode Binary_tree = obj.buildTree(inorder, postorder);
        System.out.println("The Inorder Tree Traversal is");
        obj.printInorder(Binary_tree);

    }

}
