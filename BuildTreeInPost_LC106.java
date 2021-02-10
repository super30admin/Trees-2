/**
Time: O(n)
Space: O(n) + O(n) => O(n)

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
    int postIndex;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        postIndex = postorder.length - 1;
        
        return buildBinaryTree(inorder, postorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildBinaryTree(int[] inorder, int[] postorder, int inStart, int inEnd){
        if(inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;
        int index = map.get(root.val);
        
        //build right tree first
        root.right = buildBinaryTree(inorder, postorder, index + 1, inEnd);
        
        root.left = buildBinaryTree(inorder, postorder, inStart, index - 1);
        
        return root;
    }
}