
/**
Time Complexity: O(n)
 Space Complexity: O(n)
 */

import java.util.*;

class Node {
    int val;
    TreeNode left, right;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructBinaryTreeFromINorderAndPOSTorderTraversal {
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        index = postorder.length - 1;
        return build(inorder, postorder, map, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, HashMap<Integer, Integer> map, int start, int end) {
        if (start > end) return null;

        TreeNode root = new TreeNode(postorder[index--]);
        int pos = map.get(root.val);

        root.right = build(inorder, postorder, map, pos + 1, end);
        root.left = build(inorder, postorder, map, start, pos - 1);

        return root;
    }


    public void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromINorderAndPOSTorderTraversal sol = new ConstructBinaryTreeFromINorderAndPOSTorderTraversal();

        int[] inorder =   {4, 2, 1, 3};
        int[] postorder = {4, 2, 3, 1};

        TreeNode root = sol.buildTree(inorder, postorder);
        System.out.print("Inorder traversal of built tree: ");
        sol.printInorder(root);
    }
}
