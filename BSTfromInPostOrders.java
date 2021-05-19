/*
Desc : we use the same logic as used in creation of BT from preNinorder arrays. We iterate for the index of root
from right to left in the postorder array.
Time Complexity : O(n)
Space Complexity :O(h)
 */
class Solution {
    public HashMap<Integer,Integer> hm1 =new HashMap<Integer,Integer>();
    public int pos=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         if(inorder.length==0)
         {
             return null;
         }
        
        for(int i=0;i<inorder.length;i++)
        {
            hm1.put(inorder[i],i);
        }
        pos=postorder.length-1;
        
        return buildIt(postorder,inorder,0,inorder.length-1);
    }
    public TreeNode buildIt(int []postorder,int []inorder,int startIn,int startEnd)
    {
        if(startIn>startEnd)
        {
            return null;
        }
        
        int val=postorder[pos];
        pos--;
        TreeNode root=new TreeNode(val);
        
        int index=hm1.get(val);
        root.right=buildIt(postorder,inorder,index+1,startEnd);
        root.left=buildIt(postorder,inorder,startIn,index-1);
        return root;
    }
}
