class TreeFromPostOrderAndInorder {
    Map<Integer, Integer> map = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null){
            return null;
        }

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return createTree(preorder, 0,  preorder.length -1);
    }

    private TreeNode createTree(int[] preorder, int min, int max){
        //base
        if(min>max){
            return null;
        }

        //logic
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = createTree(preorder, min, rootIdx - 1);
        root.right = createTree(preorder, rootIdx + 1, max);

        return root;
    }
}
