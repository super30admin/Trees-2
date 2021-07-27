class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length == 0){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        int index = -1;
        
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
            }
        }
        
        // int leftSize = index;
        // int rightSize = inorder.length - 1 - index;
        
        int[] leftIn = Arrays.copyOfRange(inorder, 0, index) ;
        int[] leftPost = Arrays.copyOfRange(postorder, 0, index);
        
        int[] rightIn = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] rightPost = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        
        root.left = buildTree(leftIn, leftPost);
        root.right = buildTree(rightIn, rightPost);
        
        return root;
         
    }
}

//Time : O(n)
//Space : O(n)