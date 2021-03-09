// The last element in the postorder traversal is the root element of our new tree, and we need to find the index of that root element in 
// the inorder array. The element towards left of the root element falls to the left subtree and elements towards right of root falls 
// towards right of the root node. 

// Time Complexity : O(N)
// Space Complexity : O(N)

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    int postIndex = 0;
    Map<Integer, Integer> m = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        int index = 0;
        for (int n : inorder) {
            m.put(n, index++);
        }
        return helper(0, inorder.length - 1, inorder, postorder);
    }

    private TreeNode helper(int left, int right, int[] inorder, int[] postorder) {
        if (left > right)
            return null;
        int rootValue = postorder[postIndex];
        TreeNode root = new TreeNode(rootValue);
        int index = m.get(rootValue);
        postIndex--;

        root.right = helper(index + 1, right, inorder, postorder);
        root.left = helper(left, index - 1, inorder, postorder);

        return root;
    }

    public void printTree(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };

        TreeNode root = tree.buildTree(inorder, postorder);
        tree.printTree(root);
    }
}