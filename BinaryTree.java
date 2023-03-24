/*the time complexity of this implementation is O(n)*/
import javax.swing.tree.TreeNode;

class BinaryTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTreeHelper(inorder, 0, n - 1, postorder, 0, n - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inStart;
        int rightSize = inEnd - rootIndex;

        root.left = buildTreeHelper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = buildTreeHelper(inorder, rootIndex + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 6, 3};
        int[] postorder = {4, 5, 2, 6, 3, 1};

        BinaryTree solution = new BinaryTree();
        TreeNode root = solution.buildTree(inorder, postorder);

        // Traverse the tree using pre-order traversal to check if it's built correctly
        System.out.print("Pre-order traversal: ");
        printPreOrder(root);
    }

    private static void printPreOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

}
