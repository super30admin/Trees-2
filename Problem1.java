class Problem1 {
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        // int rootIndex= preorder[0];
        postIndex= postorder.length-1;

        return helper(postorder, map, 0,inorder.length-1);

    }
    private TreeNode helper(int[] postorder,  HashMap<Integer,Integer> map,int start,int end){
        if(start> end) return null;
        int rootVal = postorder[postIndex--];
        TreeNode root= new TreeNode(rootVal);

        int rootIdx = map.get(rootVal);

        root.right= helper(postorder,map,rootIdx+1,end);
        root.left=helper(postorder,map,start,rootIdx-1);

        return root;




    }
}