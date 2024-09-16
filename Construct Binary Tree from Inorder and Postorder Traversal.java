// Time Complexity : o(n)
// Space Complexity : o(height of the tree) or worst case o(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer> ();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
           
        }
       
        int x=0,y=0;
        return buildTreeNode(inorder,postorder,x,y,map,inorder.length);
    }
    public TreeNode buildTreeNode(int[] inorder, int[] postorder,int x,int y,HashMap map,int size){
         if(size==0)return null;
        if(size==1) return new TreeNode(postorder[y]);
       int root=postorder[y+size-1];  
       
     int rootIndex = (int)map.get(root);
             System.out.println(rootIndex);
         TreeNode node =new TreeNode(root);
        int leftarray = (rootIndex-1)-x+1;
     int rightarray = size -(leftarray+1);
        
        node.left = buildTreeNode(inorder,postorder,x,y,map,leftarray);
         node.right = buildTreeNode(inorder,postorder,rootIndex+1,y+leftarray,map,rightarray);
      return node;
    }
    
}
