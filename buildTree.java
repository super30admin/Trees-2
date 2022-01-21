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
    
    Map<Integer,Integer> map;
    int idx;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.idx = postorder.length-1;
        System.out.println(idx);
        if(postorder == null && postorder.length == 0) return null;
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(postorder, 0, inorder.length-1);   
    }
    
    private TreeNode helper(int[] postorder, int start, int end){
        
        if(start > end) return null;
        
        int rootval = postorder[idx];
        
        idx--;
        TreeNode root = new TreeNode(rootval);
        int rootindex = map.get(rootval);
        
        
        root.left = helper(postorder, start, rootindex-1);
        root.right = helper(postorder, rootindex+1, end);
        
        return root;
        
    }
}




// Time Complexity : o(N)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach