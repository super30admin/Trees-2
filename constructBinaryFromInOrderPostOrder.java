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
    Map<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || inorder==null ||postorder.length==0) return null;
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length-1;
        return helper(postorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] postorder, int start, int end) {
        // base
        if(start>end || idx < 0) return null;
        // logic
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx--;
        int rootIdx = map.get(rootVal);
        root.right = helper(postorder, rootIdx+1, end);
        root.left = helper(postorder, start, rootIdx-1);
        
        return root;
    }
}