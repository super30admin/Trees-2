
public class InorderandPostorderTree {
  Map<Integer, Integer> inorderMap;
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {   
        if(postorder == null || postorder.length == 0)
            return null;
        int n = postorder.length;
        postIdx = n-1;
        inorderMap = new  HashMap<>();
        for(int i = 0 ; i< n ; i++){
        inorderMap.put(inorder[i],i);
        }
        return helper(inorder,postorder,0, n-1);
    }
    
    private TreeNode helper( int[] inorder, int[] postorder, int start, int end){
        if(start > end) return null;
        int rootVal = postorder[postIdx];
        postIdx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inorderMap.get(rootVal);
        root.right = helper(inorder,postorder, rootIdx+1, end);
        root.left = helper( inorder,postorder, start, rootIdx-1);
        
        return root;
        
    }

}
