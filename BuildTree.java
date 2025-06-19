/* Problem: Given inorder and postorder traversal of a binary tree, construct the binary tree.
 * 
 * Approach:
 * 1. Use a HashMap to store the indices of inorder elements for quick access.
 * 2. Start from the end of postorder array to get the root node.
 * 3. Recursively build the right subtree first, then the left subtree.
 * 
 * Time Complexity: O(n), where n is the number of nodes in the tree.
 * Space Complexity: O(n), for the HashMap and recursion stack.
 */
public class BuildTree {
    int index;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start > end)
            return null;

        int rootValue = postorder[index--];

        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = map.get(rootValue);


        root.right = build(inorder, postorder, inorderIndex + 1, end);
        root.left = build(inorder, postorder, start, inorderIndex - 1);

        return root;

    }
}
