// Time Complexity : O(N)
// Space Complexity : O(H) can go up to O(N) for skewed tree
// Did this code successfully run on Leetcode : Yes
// We do this recursively, a postOrderIndex is used to keep track of the current root node value from the postorder array. By finding the position of the root value in the inorder array, the function determines the elements in the left and right subtrees. The process is repeated recursively for each subtree until the entire tree is constructed.

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeFromInorderAndPostorder {

    int postOrderIndex;
    HashMap<Integer, Integer> inOrderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length - 1;
        inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        // if(postOrderIndex<0 || start>end) return null;
        // Root- Right -Left
        TreeNode root = new TreeNode(postorder[postOrderIndex--]);
        int position = inOrderMap.get(root.val);

        root.right = helper(postorder, position + 1, end);
        root.left = helper(postorder, start, position - 1);
        return root;
    }

    public static void main(String[] args) {

        int[] postOrder = { 9, 15, 7, 20, 3 };
        int[] inOrder = { 9, 3, 15, 20, 7 };
        BinaryTreeFromInorderAndPostorder obj = new BinaryTreeFromInorderAndPostorder();
        TreeNode root = obj.buildTree(inOrder, postOrder);

        // Display the resulting tree using inorder traversal
        System.out.println("Inorder Traversal:");
        inorderTraversal(root);
    }

    private static void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }

}
