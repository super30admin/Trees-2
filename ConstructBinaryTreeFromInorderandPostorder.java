// Time complexity:- O(n)
// Space complexity:- O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach: 
 * This problem is about constructing a binary tree using inorder and postorder traversal arrays.  
 * I used a recursive approach where the root is taken from the end of postorder, and its index in inorder helps 
 * split the tree into left and right subtrees. A hashmap is used for quick index lookup, and we build the right subtree 
 * first, then the left, because we are traversing postorder in reverse.
 */
class Solution {
    private int postIndex;
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Initialize postIndex to the last element in postorder
        postIndex = postorder.length - 1;

        // Map each value to its index in inorder array for quick access
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int inStart, int inEnd) {
        // Base case: no elements to construct the tree
        if (inStart > inEnd) {
            return null;
        }

        // Get the current root value and create a node
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // If there are no more elements in this subtree
        if (inStart == inEnd) {
            return root;
        }

        // Get the index of the root value in the inorder array
        int inIndex = inorderMap.get(rootVal);

        // Build right subtree before left since we're going backwards in postorder
        root.right = build(postorder, inIndex + 1, inEnd);
        root.left = build(postorder, inStart, inIndex - 1);

        return root;
    }
}
