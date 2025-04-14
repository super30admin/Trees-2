/*
Time Complexity -> O(N*N)
Space COmplexity -> O(H*H)
*/


class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        int post_length = postorder.length;
        int in_length = inorder.length;
        int rootVal = postorder[post_length - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = 0; i < in_length; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
            }
        }
        int[] inorder_left = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorder_right = Arrays.copyOfRange(inorder, rootIndex + 1, in_length);
        int[] post_left = Arrays.copyOfRange(postorder, 0, rootIndex);
        int[] post_right = Arrays.copyOfRange(postorder, rootIndex, post_length - 1);

        root.left = buildTree(inorder_left, post_left);
        root.right = buildTree(inorder_right, post_right);
        return root;
    }
}


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
 * 
 */

 /*
Time COmplexity -> O(N)
Space COmpelxity -> O(H)
 */
class Solution2 {
    int rootIdx;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        rootIdx = postorder.length -1 ;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recurse(postorder, 0, postorder.length - 1);
    }

    private TreeNode recurse(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int post_len = postorder.length;
        int rootVal = postorder[rootIdx];
        rootIdx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        root.right = recurse(postorder, rootIndex + 1, end);
        root.left = recurse(postorder, start, rootIndex - 1);
        return root;
    }
}

