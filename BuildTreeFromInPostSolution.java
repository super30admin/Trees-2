/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
class BuildTreeFromInPostSolution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                // index of root in inorder
                rootIndex = i;
                break;
            }
        }
        // Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        // Output: [3,9,20,null,null,15,7]
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, rootIndex);
        int[] postorderRight = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);

        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);

        return root;
    }
}