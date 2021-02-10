// Time Complexity :O(n)
// Space Complexity :O(n+depth of tree)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// we are keeping hashmap of inorder elements and their indexes.we are starting from end of the postorder array 
// last index of the postorder would be the root and as an when we are traversing the postorder array from left to right 
//  we are finding its left and right in the inorder array and then recursively calling for right and left branch
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
    Map<Integer,Integer> hashmap; 
    int postindex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        hashmap = new HashMap<>();
        postindex = postorder.length-1;
        
        for(int i=0;i<inorder.length;i++){
            hashmap.put(inorder[i],i);
        }
        
        return buildNewTree(inorder,postorder,0,postorder.length-1);
    }
    public TreeNode buildNewTree(int[] inorder,int[] postorder,int instart,int inend){
        if(instart>inend){
            return null;
        }
        
        
        TreeNode root = new TreeNode(postorder[postindex]);
        postindex--;
        
        //Root,Right,Left
        int index = hashmap.get(root.val);
        
        root.right = buildNewTree(inorder,postorder,index+1,inend);
        root.left = buildNewTree(inorder,postorder,instart,index-1);
        
                
        return root;
        
    }
    
}