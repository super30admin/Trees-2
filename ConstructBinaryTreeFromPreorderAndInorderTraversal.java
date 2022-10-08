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

// Time Complexity :O(n*n)
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
// class Solution {
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if(preorder == null || preorder.length == 0 || inorder.length == 0)
//             return null;
//         int rootVal = preorder[0];
//         TreeNode root = new TreeNode(rootVal);
//         int rootIdx = -1;
//         for(int i = 0; i < inorder.length; i++){
//             if(rootVal == inorder[i]){
//                 rootIdx = i;
//                 break;
//             }
//         }
        
//         int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
//         int[] inorderRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        
//         int[] preorderLeft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
//         int[] preorderRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);
        
//         root.left = buildTree(preorderLeft, inorderLeft);
//         root.right = buildTree(preorderRight, inorderRight);
        
//         return root;
        
//     }
// }

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(start > end)
            return null;
        
        int rootVal = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        
        root.left = helper(preorder, inorder, start, rootIdx - 1);
        root.right = helper(preorder, inorder, rootIdx + 1, end);
        
        return root;
        
            
    }
}
