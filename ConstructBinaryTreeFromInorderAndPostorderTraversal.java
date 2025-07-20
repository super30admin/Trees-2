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
    int index;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    // If preorder given, index starts from 0 but for postorder start from last index. 
    // Since post is L-R-Root, while coming from end of the array, right node is encountered first in postorder.
    // So build the RST first then LST.
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || 
        inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }

        index = postorder.length - 1;

        for (int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }

        return dfs(postorder, 0, inorder.length - 1);
        
    }

    private TreeNode dfs(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = postorder[index];
        TreeNode root = new TreeNode(rootVal);
        index--;

        int rootIdx = inorderMap.get(rootVal);

        root.right = dfs(postorder, rootIdx + 1, end);
        root.left = dfs(postorder, start, rootIdx - 1);

        return root;
    }
}