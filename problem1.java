class constructoBinarySearchFromInorderAndPostOrder{
    HashMap<Integer, Integer> map;
        int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0) return null;
        
        map = new HashMap<>();
        index = postorder.length - 1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return helper(inorder, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        if(start>end){
            return null;
        }
        
        if(index <0){
            return null;
        }
        int rootVal = postorder[index];
        index--;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        
        root.right = helper(inorder, postorder, rootIndex+1, end);
        root.left = helper(inorder, postorder, start, rootIndex -1);
        
        return root;
    }
}