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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    final Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
    }
    return build(inorder, postorder, postorder.length - 1, 0, 
inorder.length - 1, map);
    }

    private TreeNode build(int[] inorder, int[] postorder, int 
postorderHeadIndex, int inorderHeadIndex, int inorderTailIndex, 
Map<Integer, Integer> map) {
        if(inorderHeadIndex > inorderTailIndex || postorderHeadIndex < 0) 
return null;
        int index = map.get(postorder[postorderHeadIndex]);
        final TreeNode node = new TreeNode(postorder[postorderHeadIndex]);
        node.right = build(inorder, postorder, postorderHeadIndex - 1, 
index + 1, inorderTailIndex, map);
        node.left = build(inorder, postorder, postorderHeadIndex - 1 - 
(inorderTailIndex - index), inorderHeadIndex, index - 1, map);
        return node;
    }
}
