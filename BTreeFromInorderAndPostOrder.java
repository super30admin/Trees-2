// Time Complexity: O(n)
// Space Complexity: O(n) 
class Solution {
    int postIndex;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] postorder, int start, int end) {
        if (start > end || postIndex < 0) return null;
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = map.get(rootVal);
        root.right = helper(postorder, inorderIndex + 1, end);
        root.left = helper(postorder, start, inorderIndex - 1);
        return root;
    }
}
