// 106. Construct Binary Tree from Inorder and Postorder Traversal

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
    
    HashMap <Integer,Integer> map;
    int idx; 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder == null || inorder.length == 0) return null;
        map = new HashMap<>();
        idx = postorder.length -1;
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(postorder, 0, inorder.length-1);
    }
    
    private TreeNode helper(int [] postorder, int start, int end){
        if(start > end){
            return null;
        } 
        int rootVal = postorder[idx];
        idx--; 
        int rootInx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, rootInx +1, end);
        root.left = helper(postorder, start, rootInx-1);
        
    return root;
    }
}

/* 
Complexity Analysis
Time complexity : O(N).
Building the hashmap takes O(N) time, as there are N nodes to add, and adding items to a hashmap has a cost of O(1),
Space complexity : 
O(N) Building the hashmap and storing the entire tree each requires O(N) memory.

*/