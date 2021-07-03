// Time Complexity :O(n) n-number of nodes
// Space Complexity :O(h) h- maximum height of the tree 
// Did this code successfully run on Leetcode :yes 
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
    int index;
    HashMap<Integer,Integer> map=new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=postorder.length-1;
        for(int i=0;i<inorder.length;i++)
        {
         map.put(inorder[i],i);   
        }
        
    return helper(inorder,postorder,0,postorder.length-1);
    }
    public TreeNode helper(int[] inorder,int[] postorder,int start,int end)
    {
        if(start>end || index<0) return null;
        TreeNode root=new TreeNode(postorder[index]);
        int inInd=map.get(root.val);
        index--;
       
        root.right=helper(inorder,postorder,inInd+1,end);
        root.left=helper(inorder,postorder,start,inInd-1);
        
        return root;
    }
}