// using similar approach like inorder and preorder
// first we build right subtree and then left subtree
// Time : O(n), Space: O(n)

class Solution {
    HashMap<Integer, Integer> map;
    int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.postIdx = postorder.length - 1;

        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        if (start > end) return null;

        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        // Build right subtree first, then left subtree
        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);

        return root;
    }
}
