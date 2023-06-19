// Time Complexity o(h) Space complexity o(h)
class Solution {
    int idx;
    HashMap<Integer, Integer> m;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        m = new HashMap<>();
        idx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] postorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        
        int rootVal = postorder[idx--];
        int rootIdx = m.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.right = helper(postorder, inorder, rootIdx + 1, end);
        root.left = helper(postorder, inorder, start, rootIdx - 1);

        return root;
    }
}