// Time Complexity: O(n)
// Space Complexity: o(n)

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
class Solution1 {
    HashMap<Integer, Integer> map;
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length-1;
        this.postIdx = n;
        this.map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0 , n);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        if( start > end) {
            return null;
        }
        int rootVal = postorder[postIdx];
        int rootIdx = map.get(rootVal);
        postIdx--;
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, rootIdx+1, end);
        root.left = helper(postorder, start, rootIdx-1);

        return root;
    }
}