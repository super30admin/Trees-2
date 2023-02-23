// TC: O(n)
// SC: O(1)
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int pInd;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        pInd = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }
    private TreeNode build(int[] inorder, int[] postorder, int l, int r) {
        // base
        if(l > r) {
            return null;
        }

        // logic
        TreeNode root = new TreeNode(postorder[pInd]);
        pInd--;
        int loc = map.get(root.val);
        root.right = build(inorder, postorder, loc + 1, r);
        root.left = build(inorder, postorder, l, loc - 1);
        return root;
    }
}