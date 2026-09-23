

// ### Approach

// 1. Store every value's index in `inorder` using a `HashMap` for `O(1)` average lookup.
// 2. Process `postorder` from right to left; each value is the current root, and its `inorder` position divides left and right subtrees.
// 3. Build the **right subtree first**, then the left subtree, because postorder is being traversed backwards.

// **Time Complexity:** O(n)
// **Space Complexity:** O(n) — HashMap + recursion stack.


import java.util.HashMap;
import java.util.Map;

class BinaryTreeInPost {

private int postorderIndex;
private Map<Integer, Integer> inorderMap;

public TreeNode buildTree(int[] inorder, int[] postorder) {

    if (inorder == null || postorder == null ||
        inorder.length == 0 || postorder.length == 0) {
        return null;
    }

    inorderMap = new HashMap<>();

    // Store each value's index in inorder
    for (int i = 0; i < inorder.length; i++) {
        inorderMap.put(inorder[i], i);
    }

    // Start from the last element of postorder
    postorderIndex = postorder.length - 1;

    return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
}

private TreeNode buildTreeHelper(
        int[] inorder,
        int[] postorder,
        int left,
        int right) {

    if (left > right) {
        return null;
    }

    // The current postorder element is the root
    int rootValue = postorder[postorderIndex--];
    TreeNode root = new TreeNode(rootValue);

    // Find the root's position in inorder
    int rootIndex = inorderMap.get(rootValue);

    // Build right subtree first because we are
    // processing postorder from right to left
    root.right = buildTreeHelper(
            inorder,
            postorder,
            rootIndex + 1,
            right
    );

    // Build left subtree
    root.left = buildTreeHelper(
            inorder,
            postorder,
            left,
            rootIndex - 1
    );

    return root;
}

}

