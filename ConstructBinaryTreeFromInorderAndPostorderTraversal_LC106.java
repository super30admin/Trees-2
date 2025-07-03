// Time Complexity : O(n) — we visit each node once, and hashmap lookup is O(1).
// Space Complexity : O(n) — for recursion stack (in worst case unbalanced tree) + hashmap.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ConstructBinaryTreeFromInorderAndPostorderTraversal_LC106 {

    // start from the last postorder element
    int postIdx;

    HashMap<Integer, Integer> inorder_map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++)
            inorder_map.put(inorder[i], i);

        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int startIdx, int endIdx) {
        
        //base case
        if (startIdx > endIdx) return null;

        int rootValue = postorder[postIdx--];
        TreeNode rootNode = new TreeNode(rootValue);

        int rootIndex = inorder_map.get(rootValue);

        // Right subtree first (because we are going backwards in postorder)
        rootNode.right = build(postorder, rootIndex + 1, endIdx);
        rootNode.left = build(postorder, startIdx, rootIndex - 1);

        return rootNode;
    }

}