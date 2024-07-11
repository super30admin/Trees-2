class Solution {
    private int[] postorder;             // Array to store postorder traversal of nodes
    private int idx;                     // Index for accessing nodes in postorder array
    private HashMap<Integer, Integer> inorderMap;  // HashMap to store indices of inorder traversal nodes
    
    // Method to build a binary tree from inorder and postorder traversals
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.idx = postorder.length - 1;  // Start index for accessing nodes from the end of postorder array
        this.inorderMap = new HashMap<>(inorder.length);  // Initialize hashmap to store indices of inorder nodes
        
        // Populate the inorderMap with indices of inorder traversal nodes
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        this.postorder = postorder;  // Store the postorder traversal array
        return helper(0, inorder.length - 1);  // Recursively build the tree and return the root
    }

    // Helper method to recursively build the tree
    private TreeNode helper(int leftIdx, int rightIdx) {
        // Base case: If left index exceeds right index, return null
        if (leftIdx > rightIdx) {
            return null;
        }

        // Extract the root value from postorder array using idx
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);  // Create a new node with root value
        idx--;  // Decrement idx to access next root value in postorder array
        
        // Find the index of root value in inorderMap
        int rootIdx = inorderMap.get(rootVal);

        // Recursively build the right subtree first, then the left subtree
        root.right = helper(rootIdx + 1, rightIdx);  // Construct right subtree
        root.left = helper(leftIdx, rootIdx - 1);     // Construct left subtree

        return root;  // Return the constructed root node
    }
}
