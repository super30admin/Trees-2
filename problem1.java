
class Solution {


    public class TreeNode {
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

    int p=0;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        p=postorder.length-1;
        return helper(inorder, postorder, 0, p);
          
        
    }
    
    
    public TreeNode helper(int[] inorder, int[] postorder, int l, int r){
        
        
        if(l>r){return null;}
        
        TreeNode node= new TreeNode(postorder[p]);
        
        int x=0;
        for( int i=0;i<postorder.length;i++)
        {if(postorder[p]==inorder[i]){x=i;}
        }
        p--;
        if(l==r){return node;}
        
       
        node.right=helper(inorder, postorder,x+1,r);
        node.left=helper(inorder, postorder,l,x-1);
        return node;
        
    }
}

//TC: O(n);
//SC: recursive stack 