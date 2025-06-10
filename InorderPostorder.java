class Solution {
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        this.idx = postorder.length-1;

        TreeNode result = helper(postorder, map, 0,inorder.length-1);

        return result;
        
    }

    private TreeNode helper(int[] postorder ,Map<Integer, Integer> map, int start, int end){
        //base
        if(start>end) return null;
        //logic
        int rootVal = postorder[idx--];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.right = helper(postorder, map, rootIdx+1, end);
        root.left = helper(postorder, map, start, rootIdx-1);
        
        return root;


    }
}