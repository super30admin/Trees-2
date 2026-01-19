
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeWithPostAndInOrderTraversal {

    // Basic tree node
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    /*
     APPROACH 1 (Brute force / slicing arrays)
     Idea:
     - In postorder, the LAST element is always the root.
     - Find root in inorder to split into left subtree + right subtree.
     - Use sizes of inorder splits to slice postorder into left part + right part.
     - Recurse on subarrays.

     Time Complexity:
     - Finding root index in inorder is O(n) each recursion
     - Copying ranges (Arrays.copyOfRange) is also O(n)
     - Overall: O(n^2) time in worst case, O(n^2) space due to new arrays each recursion
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return treeHelper(inorder, postorder);
    }

    private TreeNode treeHelper(int[] inorder, int[] postorder) {
        // Base case: no elements to construct a tree
        if (inorder.length == 0 || postorder.length == 0) return null;

        // Root is the last element in postorder
        int rootVal = postorder[postorder.length - 1];

        // Find root position in inorder to split left/right subtrees
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // Split inorder into left and right
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inorderRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        // Left subtree size tells us how to split postorder
        int leftSize = inorderLeft.length;

        // Split postorder into left and right (excluding last root element)
        int[] postLeft = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] postRight = Arrays.copyOfRange(postorder, leftSize, postorder.length - 1);

        // Build root and recurse
        TreeNode root = new TreeNode(rootVal);
        root.left = treeHelper(inorderLeft, postLeft);
        root.right = treeHelper(inorderRight, postRight);

        return root;
    }

    /*
     APPROACH 2 (Optimal / HashMap + index pointer)
     - Use a HashMap to get inorder index in O(1).
     - Use a global pointer idx starting from end of postorder (root first).
     - Recurse using inorder boundaries (start..end) without slicing arrays.
     - IMPORTANT: build RIGHT subtree first, then LEFT subtree.
       Why? Because postorder ends with: [left subtree..., right subtree..., root]
       When scanning from the end, after root comes RIGHT subtree nodes, then LEFT.

     Time Complexity:
     - Building map: O(n)
     - Each node processed once: O(n)
     => Total O(n) time
     Space:
     - HashMap: O(n)
     - Recursion stack: O(h), worst case O(n)
     */
    private int idx; // moving pointer for postorder (starts at end)

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;

        Map<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }

        return treeHelper2(postorder, inIndex, 0, inorder.length - 1);
    }

    private TreeNode treeHelper2(int[] postorder, Map<Integer, Integer> inIndex, int start, int end) {
        if (start > end) return null;

        // Current root from postorder[idx]
        int rootVal = postorder[idx--];
        TreeNode root = new TreeNode(rootVal);

        int mid = inIndex.get(rootVal);

        // Build right first (explained above)
        root.right = treeHelper2(postorder, inIndex, mid + 1, end);
        root.left = treeHelper2(postorder, inIndex, start, mid - 1);

        return root;
    }

    //Traversal helpers (for testing / printing)
    // Print inorder traversal (Left, Root, Right)
    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Print postorder traversal (Left, Right, Root)
    private static void printPostorder(TreeNode root) {
        if (root == null) return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
    }

    // Print preorder traversal (Root, Left, Right) (optional, helps sanity check)
    private static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // Simple main test (no assertions)
    public static void main(String[] args) {
        BinaryTreeWithPostAndInOrderTraversal builder = new BinaryTreeWithPostAndInOrderTraversal();

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        System.out.println("Input:");
        System.out.println("inorder   = " + Arrays.toString(inorder));
        System.out.println("postorder = " + Arrays.toString(postorder));
        System.out.println();

        // Build using optimal approach
        TreeNode root = builder.buildTree2(inorder, postorder);

        System.out.println("Traversals of constructed tree:");
        System.out.print("Preorder  : ");
        printPreorder(root);
        System.out.println();

        System.out.print("Inorder   : ");
        printInorder(root);
        System.out.println();

        System.out.print("Postorder : ");
        printPostorder(root);
        System.out.println();
    }
}

