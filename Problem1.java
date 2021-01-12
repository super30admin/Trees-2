// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Time complexity : O(N)
// Space complexity : O(N)
// Did this code successfully run on Leetcode : YES

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, m);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int inLow, int inHigh, int poLow, int poHigh,
            HashMap<Integer, Integer> m) {
        if (inLow > inHigh || poLow > poHigh)
            return null;

        TreeNode root = new TreeNode(postorder[poHigh]);
        int index = m.get(root.val);
        int leftLen = index - inLow;
        int rightLen = inHigh - index;

        root.left = helper(inorder, postorder, inLow, index - 1, poLow, poLow + leftLen - 1, m);
        root.right = helper(inorder, postorder, index + 1, inHigh, poLow + leftLen, poHigh - 1, m);
        return root;
    }
}
