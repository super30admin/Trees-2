// TC : O(n)
// SC : O(n)
class Solution {
    int idx;
    HashMap<Integer, Integer> inorderMap = new HashMap<>();;
    public TreeNode build(int[] postorder, int s, int e) {
        if(s > e || idx < 0) return null;
        System.out.println(idx);
        int root = postorder[idx];
        idx--;
        TreeNode node = new TreeNode(root);
        int nodeIdx = inorderMap.get(root);
        node.right = build(postorder, nodeIdx + 1, e);
        node.left = build(postorder, s, nodeIdx - 1);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0 ; i<inorder.length ; i++) {
            inorderMap.put(inorder[i], i);
        }
        idx = postorder.length - 1;
        return build(postorder, 0, inorder.length - 1);
    }
}