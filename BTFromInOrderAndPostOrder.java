import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class BTFromInOrderAndPostOrder {
    int postIndex=0;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //We can construct a binary tree only when two traversals are given
        //Inorder is a must (We need one more)
        //Combinations are inorder and preorder 
        //and inorder and postorder
        
        //Inorder:   Left Root  Right
        //Postorder: Left Right Root
        //Traverse from back PostOrder
         map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        map.put(inorder[i],i);
        postIndex=postorder.length-1;
        
        return constructTree(inorder,postorder,0,inorder.length-1); 
    }
    
   public TreeNode constructTree(int[] inorder, int[] postorder,int inorderStart,int inorderEnd) 
   {
       if(inorderStart>inorderEnd)
           return null;
       TreeNode root=new TreeNode(postorder[postIndex--]);
       int inorderIndex=map.get(root.val);
       
       root.right=constructTree(inorder,postorder,inorderIndex+1,inorderEnd);
       root.left=constructTree(inorder,postorder,inorderStart,inorderIndex-1);
       
       return root;
       
   }
}
