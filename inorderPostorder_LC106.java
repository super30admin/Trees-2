class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //basecase
        if(postorder.length==0 && inorder.length == 0) return null;
        
        //find root element and form root node
        int rootval = postorder[ postorder.length-1];
        TreeNode root = new TreeNode(rootval);
        
        //find the rootindex of root in in order to find the subtrees
       int rootindex=0;
        for(int i=0; i<inorder.length;i++){
            if(inorder[i]==rootval){
                rootindex = i;
                break;
            }
        }
        
        //create the new postorder and inorder for left subtree and right subtree
        
        int[] inleft = Arrays.copyOfRange(inorder, 0, rootindex);
        int[] inright = Arrays.copyOfRange(inorder, rootindex+1 , inorder.length);
        int[] postleft = Arrays.copyOfRange(postorder, 0 , rootindex);
        int[] postright =Arrays.copyOfRange(postorder, rootindex , postorder.length-1);
        
        
        //recursive call and form the left and right subtree
        root.left = buildTree(inleft, postleft);
        root.right = buildTree(inright,postright);
        
        return root;
        
        
        
    }
}