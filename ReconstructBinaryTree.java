/**
 * Idea is to use recursion to genearate the binary tree.
 * Explanation in the comments.
 * 
 * Time Complexity: O(n) 
 * Space Complexity: O(n), worst case
 * 
 * Leetcode Result:
 * 
 * Runtime: 2 ms, faster than 93.41% of Java online submissions for Construct
 * Binary Tree from Inorder and Postorder Traversal. Memory Usage: 37.8 MB, less
 * than 32.73% of Java online submissions for Construct Binary Tree from Inorder
 * and Postorder Traversal.
 */
class ReconstuctBinaryTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // map to store element --> index mapping
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // call the buildTree helper
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length, map);
    }

    /**
     * 
     * @param inorder   traversal of binary tree
     * @param i         first index of subarray that we are looking at
     * @param iSize     size of inorder array, in this call
     * @param postorder traversal of binary tree
     * @param p         first index of subarray that we are looking at
     * @param pSize     size of postorder array, in this call
     * @param map       maps elements of tree to its inorder index
     * @return binary tree from provided params
     */
    private TreeNode buildTree(int[] inorder, int i, int iSize, int[] postorder, int p, int pSize,
            HashMap<Integer, Integer> map) {
        // base case check
        if (iSize <= 0) {
            return null;
        }
        // single element, leaf node
        if (iSize == 1) {
            return new TreeNode(postorder[p]);
        }
        // obtain root value from the last element in the current postorder array
        // obtain the corresponding inorder index from the map
        // compute left and right size as partitioned wrt root 
        int rootValue = postorder[p + pSize - 1];
        int rootIndex = map.get(rootValue);
        int leftSize = (rootIndex - 1) - i + 1;
        int rightSize = pSize - leftSize - 1;
        // create a node
        TreeNode root = new TreeNode(rootValue);
        // recursively build left and right subtree
        root.left = buildTree(inorder, i, leftSize, postorder, p, leftSize, map);
        root.right = buildTree(inorder, rootIndex + 1, rightSize, postorder, p + leftSize, rightSize, map);

        return root;
    }
}