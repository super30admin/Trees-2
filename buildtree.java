class Solution {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || postorder.length==0) return null;
        int idx=postorder.length-1;
        TreeNode root = new TreeNode(postorder[idx]);
        int rootidx=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                rootidx=i;
            }
        }
        int [] postleft = Arrays.copyOfRange(postorder,0,rootidx);
        int [] postright = Arrays.copyOfRange(postorder,rootidx, postorder.length-1);
        int [] inleft = Arrays.copyOfRange(inorder,0,rootidx);
        int [] inright = Arrays.copyOfRange(inorder,rootidx+1,inorder.length);
        root.left=buildTree(inleft,postleft);
        root.right=buildTree(inright,postright);

        return root;
    }
}
