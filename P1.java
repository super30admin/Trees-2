/*
Time Complexity : The time complexity of the algorithm is O(N) where N is the number of nodes in the Binary Tree. This is because each node is processed and visited exactly once.

Space Complexity : The space complexity of the algorithm is O(N + log N) where N is the number of nodes in the Binary Tree.

 */


 class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }

        // Create a map to store the indices
        // of elements in the inorder traversal
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        // Call the recursive function
        // to build the binary tree
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1, hm);
    }

    // Recursive function to build a binary
    // tree from inorder and postorder traversals
    public TreeNode buildTreePostIn(int[] inorder, int is, int ie,
                                    int[] postorder, int ps, int pe, Map<Integer, Integer> hm) {

        // Base case: If the subtree
        // is empty, return null
        if (ps > pe || is > ie) {
            return null;
        }

        // Create a new TreeNode
        // with the root value from postorder
        TreeNode root = new TreeNode(postorder[pe]);

        // Find the index of the root
        // value in inorder traversal
        int inRoot = hm.get(postorder[pe]);

        // Number of nodes in the left subtree
        int numsLeft = inRoot - is;

        // Recursively build the
        // left and right subtrees
        root.left = buildTreePostIn(inorder, is, inRoot - 1, postorder,
                ps, ps + numsLeft - 1, hm);

        root.right = buildTreePostIn(inorder, inRoot + 1, ie, postorder,
                ps + numsLeft, pe - 1, hm);

        // Return the root of
        // the constructed subtree
        return root;
    }
}