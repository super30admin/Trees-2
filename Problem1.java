// Time Complexity :O(n+n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
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
//The idea here to make every right most element of postorder as root and add tot he right first.
class Solution {
    private HashMap<Integer,Integer> map;//gloabla map to find the root in inorder
     private int postroot;//every right most element is the root and this pointer maintains that index
     public TreeNode buildTree(int[] inorder, int[] postorder) {
         map=new HashMap<>();
         postroot=postorder.length-1;
         for(int i=0;i<inorder.length;i++)
         {
             map.put(inorder[i],i);//Adding all inorder elements to map
         }
         
        return maketree(inorder,postorder,0,inorder.length-1);
     }
     private TreeNode maketree(int[] inorder, int[] postorder,int instart,int inend)
     {       
         if(instart>inend)//if we go out of bounds we know we are at a leaf node
             return null;
         
         TreeNode root= new TreeNode(postorder[postroot]);
         postroot--;
         
         int index=map.get(root.val);
        
         
         root.right=maketree(inorder,postorder,index+1,inend);//Check if new root will lie in (index+1,inend) range
         root.left=maketree(inorder,postorder,instart,index-1);//Check if new root will lie in (instart,index-1) range
        
         return root;
     }
 }