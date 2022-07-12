public class BuildBT {
    Map<Integer, Integer> map = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length-1;
        for(int i=0; i<= idx;i++){
            map.put(inorder[i],i);
        }
        
        return helper(postorder, 0, idx);
    }
    
    // TC is O(n)
    // SC is O(h)
    private TreeNode helper(int[] postorder, int start, int end){
        // base
        if(start>end) return null;
        
        // logic
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        idx--;
        root.right = helper(postorder, rootIdx+1, end);

        root.left = helper(postorder, start, rootIdx-1);
        
        return root;
    }
}
