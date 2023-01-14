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

// Time Complexity = O(N)
// Space Complexity = O(N)

class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length-1;
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, postorder.length-1);
    }
    
    private TreeNode helper (int[] postorder, int[] inorder, int start, int end){
        if(start > end) return null;
        
        int rootVal = postorder[idx--];
        TreeNode root = new TreeNode(rootVal);
        
        ///idx--;
        int rootIdx = map.get(rootVal);
        root.right = helper(postorder, inorder, rootIdx+1, end);
        
        root.left = helper(postorder, inorder, start, rootIdx-1);
        return root;
    }   
}