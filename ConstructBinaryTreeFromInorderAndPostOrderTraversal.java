/**
 * Time Complexity - O(N)
 * Space Complexity - O(N) as we are storing inorder values in hashmap
 */

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
class Solution {
    Map<Integer, Integer> inOrderIndex;
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrderIndex = new HashMap<>();
        postIndex = postorder.length - 1;
        for(int i = 0;  i < inorder.length; i++) {
            inOrderIndex.put(inorder[i], i);
        }

        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int start, int end) {
        if(start > end)
            return null;

        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inOrderIndex.get(rootValue);

        root.right = buildTreeHelper(postorder, rootIndex + 1, end);

        root.left = buildTreeHelper(postorder, start, rootIndex - 1);



        return root;

    }
}