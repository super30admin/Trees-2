package Tree;

import java.util.Arrays;


class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

//TimeComplexity : O(n)
//Space Complexity :O(n)
public class Problem1 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || postorder.length==0)
            return null;
        TreeNode node= new TreeNode(postorder[postorder.length-1]);
        
        int index=-1;
        
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==node.val){
                index=i;
                 break;
            }
           
        }
        
        
        int[] leftpostorder=Arrays.copyOfRange(postorder,0,index);
        int[] leftinorder=Arrays.copyOfRange(inorder,0,index);
        
        int[] rightinorder=Arrays.copyOfRange(inorder,index+1,inorder.length);    
        
        int[] rightpostorder=Arrays.copyOfRange(postorder,index,postorder.length-1);
        
        node.left=buildTree(leftinorder,leftpostorder);
        node.right=buildTree(rightinorder,rightpostorder);
        
        return node;
    }
	    
	    
}
