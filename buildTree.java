// Time Complexity :O(n) where n is the elements in the tree
// Space Complexity :O(n) is the size of the hashmap
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
    HashMap<Integer,Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       if(postorder.length == 0 || inorder.length == 0) return null;
        index = postorder.length -1;
        map = new HashMap<>();
        int start = 0;
        int end  = inorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return helper(postorder,inorder,start,end);
    }
    
    private TreeNode helper(int[] postorder, int[] inorder, int start, int end){
        
        //base case
        if(start > end || index<0) return null;
        
        //logic
        int inIdx = map.get(postorder[index]);
        TreeNode root = new TreeNode(postorder[index]);
        index --;
        root.right = helper(postorder,inorder,inIdx+1,end);
        root.left = helper(postorder,inorder,start,inIdx-1);
        
        
        return root;
        
    }
    
}