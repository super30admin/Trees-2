class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        
        int rootVal=preorder[0];
        int rootIdx=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                rootIdx=i;
                break;
            }
        }
        TreeNode root=new TreeNode(rootVal);
        int[] inleft=Arrays.copyOfRange(inorder,0,rootIdx);
        int[] inright=Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        int[] preleft=Arrays.copyOfRange(preorder,1,inleft.length+1);
        int[] preright=Arrays.copyOfRange(preorder,inleft.length+1,preorder.length);
        
        
        
        
        root.left=buildTree(preleft,inleft);
        root.right=buildTree(preright,inright);
        return root;
    }
}